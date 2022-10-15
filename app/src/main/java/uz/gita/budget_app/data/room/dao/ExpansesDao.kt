package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.ExpansesEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface ExpansesDao : BaseDao<ExpansesEntity> {


    @Query("select * from expanses where date between :start and :end ")
    fun getAllExpansesByDate(start: Long, end: Long): Flow<List<ExpansesEntity>>

    @Query("select sum(currencyValue*dollarValue) from expanses where date between :start and :end")
    suspend fun getExpansesSumByDate(start: Long, end: Long): Double

    @Query("select * from expanses where expansesCategoryId=:categoryId and date between :start and :end ")
    fun getAllExpansesByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<ExpansesEntity>>

    @Query("select sum(currencyValue*dollarValue) from expanses where expansesCategoryId=:categoryId and date between :start and :end")
    suspend fun getExpansesSumByCategoryDate(categoryId: Int, start: Long, end: Long): Double


}