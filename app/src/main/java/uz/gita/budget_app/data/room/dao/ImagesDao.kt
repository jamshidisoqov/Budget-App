package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.budget_app.data.room.entity.ImagesEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface ImagesDao : BaseDao<ImagesEntity> {

    @Query("select*from images where dateId=:expansesId and type='exp'")
    suspend fun getAllExpansesImages(expansesId: Int): List<ImagesEntity>


    @Query("select*from images where dateId=:incomeId and type='inc'")
    suspend fun getAllIncomeImages(incomeId: Int): List<ImagesEntity>


}