package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.IncomeEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface IncomeDao : BaseDao<IncomeEntity> {

    @Query("select * from incomes where date between :start and :end ")
    fun getAllIncomeByDate(start: Long, end: Long): Flow<List<IncomeEntity>>


    @Query("select sum(currencyValue*dollarValue) from incomes where date between :start and :end")
    suspend fun getIncomeSumByDate(start: Long, end: Long): Double

    @Query("select * from incomes where incomeCategoryId=:categoryId and date between :start and :end ")
    fun getAllIncomeByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<IncomeEntity>>

    @Query("select sum(currencyValue*dollarValue) from incomes where incomeCategoryId=:categoryId and date between :start and :end")
    suspend fun getExpansesSumByCategoryDate(categoryId: Int, start: Long, end: Long): Double
}
