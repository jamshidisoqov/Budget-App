package uz.gita.budget_app.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.models.IncomeData
import uz.gita.budget_app.data.room.entity.IncomeEntity

// Created by Jamshid Isoqov an 10/14/2022
interface IncomeUseCase {

    suspend fun insertIncomeEntity(entity: IncomeData)

    suspend fun updateIncomeEntity(entity: IncomeData)

    suspend fun deleteIncomeEntity(entity: IncomeData)

    fun getAllIncomeByDate(start: Long, end: Long): Flow<List<IncomeData>>

    suspend fun getIncomesSumByDate(start: Long, end: Long): Double

    fun getAllIncomeByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<IncomeData>>

    suspend fun getIncomesSumByCategoryDate(categoryId: Int, start: Long, end: Long): Double

}