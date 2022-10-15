package uz.gita.budget_app.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.models.ExpansesData
import uz.gita.budget_app.data.room.entity.ExpansesEntity

// Created by Jamshid Isoqov an 10/14/2022
interface ExpansesUseCase {

    suspend fun insertExpansesEntity(expansesData: ExpansesData)

    suspend fun updateExpansesEntity(expansesData: ExpansesData)

    suspend fun deleteExpansesEntity(expansesData: ExpansesData)

    fun getAllExpansesByDate(start: Long, end: Long): Flow<List<ExpansesData>>

    suspend fun getExpansesSumByDate(start: Long, end: Long): Double

    fun getAllExpansesByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<ExpansesData>>

    suspend fun getExpansesSumByCategoryDate(categoryId: Int, start: Long, end: Long): Double

}