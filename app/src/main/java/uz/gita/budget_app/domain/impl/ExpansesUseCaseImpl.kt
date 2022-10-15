package uz.gita.budget_app.domain.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.budget_app.data.models.ExpansesData
import uz.gita.budget_app.data.room.entity.CalendarEntity
import uz.gita.budget_app.domain.ExpansesUseCase
import uz.gita.budget_app.repository.BudgetRepository
import uz.gita.budget_app.utils.getCurrentDate
import javax.inject.Inject

class ExpansesUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : ExpansesUseCase {
    override suspend fun insertExpansesEntity(expansesData: ExpansesData) {
        val id = repository.insertExpansesEntity(expansesData.expansesEntity)
        repository.insertCalendarData(CalendarEntity(0, getCurrentDate(), "exp"))
        for (i in expansesData.imagesList) {
            repository.insertImagesEntity(i.copy(dateId = id.toInt()))
        }
    }

    override suspend fun updateExpansesEntity(expansesData: ExpansesData) {
        for (i in expansesData.imagesList) {
            repository.updateImagesEntity(i)
        }
    }

    override suspend fun deleteExpansesEntity(expansesData: ExpansesData) {
        repository.deleteExpansesEntity(expansesData.expansesEntity)
        for (i in expansesData.imagesList) {
            repository.deleteImagesEntity(i)
        }
    }

    override fun getAllExpansesByDate(start: Long, end: Long): Flow<List<ExpansesData>> = flow {
        repository.getAllExpansesByDate(start, end).collectLatest {
            val expansesList = ArrayList<ExpansesData>()
            for (i in it) {
                val expansesCategory = repository.getExpansesCategoryById(i.expansesCategoryId)
                val images = repository.getAllExpansesImages(i.id)
                val expansesData = ExpansesData(i, expansesCategory, images)
                expansesList.add(expansesData)
            }
            emit(expansesList)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getExpansesSumByDate(start: Long, end: Long): Double =
        repository.getExpansesSumByDate(start, end)

    override fun getAllExpansesByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<ExpansesData>> = flow {
        repository.getAllExpansesByCategoryDate(categoryId, start, end).collectLatest {
            val expansesList = ArrayList<ExpansesData>()
            for (i in it) {
                val expansesCategory = repository.getExpansesCategoryById(i.expansesCategoryId)
                val images = repository.getAllExpansesImages(i.id)
                val expansesData = ExpansesData(i, expansesCategory, images)
                expansesList.add(expansesData)
            }
            emit(expansesList)
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun getExpansesSumByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Double = repository.getExpansesSumByCategoryDate(categoryId, start, end)
}