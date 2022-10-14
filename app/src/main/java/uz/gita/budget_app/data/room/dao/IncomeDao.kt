package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface IncomeDao : BaseDao<IncomeCategoryEntity> {
    @Query("select * from incomes where date between :start and :end ")
    fun getAllIncomeByDate(start: Long, end: Long): Flow<List<IncomeEntity>>
}
