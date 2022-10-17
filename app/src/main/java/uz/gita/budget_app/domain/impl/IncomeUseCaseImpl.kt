package uz.gita.budget_app.domain.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import uz.gita.budget_app.data.models.IncomeData
import uz.gita.budget_app.data.room.entity.CalendarEntity
import uz.gita.budget_app.domain.IncomeUseCase
import uz.gita.budget_app.repository.BudgetRepository
import uz.gita.budget_app.utils.getCurrentDate
import javax.inject.Inject

class IncomeUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : IncomeUseCase {
    override suspend fun insertIncomeEntity(entity: IncomeData) {
        val id = repository.insertIncomeEntity(entity.incomeEntity)
        repository.insertCalendarData(CalendarEntity(0, getCurrentDate(), "inc"))
        for (i in entity.images) {
            repository.insertImagesEntity(i.copy(dateId = id.toInt()))
        }
    }

    override suspend fun updateIncomeEntity(entity: IncomeData) {
        repository.updateIncomeEntity(entity.incomeEntity)
    }

    override suspend fun deleteIncomeEntity(entity: IncomeData) {
        repository.deleteIncomeEntity(entity.incomeEntity)
    }

    override fun getAllIncomeByDate(start: Long, end: Long): Flow<List<IncomeData>> = channelFlow {
        repository.getAllIncomeByDate(start, end).collectLatest {
            val incomeList = ArrayList<IncomeData>()
            for (i in it) {
                val incomeCategory = repository.getIncomeCategoryById(i.incomeCategoryId)
                val images = repository.getAllExpansesImages(i.id)
                val incomeData = IncomeData(i, incomeCategory, images)
                incomeList.add(incomeData)
            }
            send(incomeList)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getIncomesSumByDate(start: Long, end: Long): Double =
        repository.getIncomesSumByDate(start, end)

    override fun getAllIncomeByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<IncomeData>> = flow {
        repository.getAllIncomeByCategoryDate(categoryId, start, end).collectLatest {
            val incomeList = ArrayList<IncomeData>()
            for (i in it) {
                val incomeCategory = repository.getIncomeCategoryById(i.incomeCategoryId)
                val images = repository.getAllExpansesImages(i.id)
                val incomeData = IncomeData(i, incomeCategory, images)
                incomeList.add(incomeData)
            }
            emit(incomeList)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getIncomesSumByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Double = repository.getIncomesSumByCategoryDate(categoryId, start, end)
}