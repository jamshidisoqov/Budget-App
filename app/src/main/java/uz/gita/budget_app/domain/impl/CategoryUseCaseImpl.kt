package uz.gita.budget_app.domain.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.CategoryEntity
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.domain.CategoryUseCase
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : CategoryUseCase {

    override suspend fun getAllCategories(): List<CategoryEntity> = repository.getAllCategories()

    override fun getAllExpansesCategories(): Flow<List<ExpansesCategoryEntity>> =
        repository.getAllExpansesCategories()

    override suspend fun getExpansesCategoryById(expanseId: Int): ExpansesCategoryEntity =
        repository.getExpansesCategoryById(expanseId)

    override suspend fun insertExpansesCategory(entity: ExpansesCategoryEntity) {
        repository.insertExpansesCategory(entity)
    }

    override suspend fun updateExpansesCategory(entity: ExpansesCategoryEntity) {
        repository.updateExpansesCategory(entity)
    }

    override suspend fun deleteExpansesCategory(entity: ExpansesCategoryEntity) {
        repository.deleteExpansesCategory(entity)
    }

    override fun getAllIncomeCategories(): Flow<List<IncomeCategoryEntity>> =
        repository.getAllIncomeCategories()

    override suspend fun getIncomeCategoryById(incomeId: Int): IncomeCategoryEntity =
        repository.getIncomeCategoryById(incomeId)

    override suspend fun insertIncomeCategory(entity: IncomeCategoryEntity) {
        repository.insertIncomeCategory(entity)
    }

    override suspend fun updateIncomeCategory(entity: IncomeCategoryEntity) {
        repository.updateIncomeCategory(entity)
    }

    override suspend fun deleteIncomeCategory(entity: IncomeCategoryEntity) {
        repository.deleteIncomeCategory(entity)
    }
}