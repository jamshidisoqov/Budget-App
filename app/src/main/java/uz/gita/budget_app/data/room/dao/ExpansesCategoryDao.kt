package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface ExpansesCategoryDao : BaseDao<ExpansesCategoryEntity> {

    @Query("select*from expanses_category")
    fun getAllExpansesCategory(): Flow<List<ExpansesCategoryEntity>>

    @Query("select*from expanses_category where id=:expanseId")
    suspend fun getExpansesCategoryById(expanseId: Int): ExpansesCategoryEntity

}