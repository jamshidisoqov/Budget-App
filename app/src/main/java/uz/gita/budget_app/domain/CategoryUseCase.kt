package uz.gita.budget_app.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.CategoryEntity
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity

// Created by Jamshid Isoqov an 10/14/2022
interface CategoryUseCase {

    suspend fun getAllCategories(): List<CategoryEntity>

    fun getAllExpansesCategories(): Flow<List<ExpansesCategoryEntity>>

    suspend fun getExpansesCategoryById(expanseId: Int): ExpansesCategoryEntity

    suspend fun insertExpansesCategory(entity: ExpansesCategoryEntity)

    suspend fun updateExpansesCategory(entity: ExpansesCategoryEntity)

    suspend fun deleteExpansesCategory(entity: ExpansesCategoryEntity)

    fun getAllIncomeCategories(): Flow<List<IncomeCategoryEntity>>

    suspend fun getIncomeCategoryById(incomeId: Int): IncomeCategoryEntity

    suspend fun insertIncomeCategory(entity: IncomeCategoryEntity)

    suspend fun updateIncomeCategory(entity: IncomeCategoryEntity)

    suspend fun deleteIncomeCategory(entity: IncomeCategoryEntity)

}