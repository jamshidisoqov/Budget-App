package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface IncomeCategoryDao : BaseDao<IncomeCategoryEntity> {

    @Query("select*from income_category")
    fun getAllIncomeCategory(): Flow<List<IncomeCategoryEntity>>

    @Query("select*from income_category where id=:incomeId")
    suspend fun getExpansesCategoryById(incomeId: Int): IncomeCategoryEntity

}