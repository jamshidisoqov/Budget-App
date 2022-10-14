package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.CategoryEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface CategoriesDao : BaseDao<CategoryEntity> {

    @Query("select*from categories")
    fun getAllCategories(): Flow<List<CategoryEntity>>

}