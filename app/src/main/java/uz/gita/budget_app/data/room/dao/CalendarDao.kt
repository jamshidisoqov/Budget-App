package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.gita.budget_app.data.room.entity.CalendarEntity

// Created by Jamshid Isoqov an 10/14/2022
@Dao
interface CalendarDao : BaseDao<CalendarEntity> {


    @Query("select*from calendar_data WHERE date=:date AND type='exp'")
    suspend fun calendarOfExistsDateExpanses(date: String): CalendarEntity

    @Query("select*from calendar_data WHERE date=:date AND type='inc'")
    suspend fun calendarOfExistsDateIncome(date: String): CalendarEntity

}