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

}