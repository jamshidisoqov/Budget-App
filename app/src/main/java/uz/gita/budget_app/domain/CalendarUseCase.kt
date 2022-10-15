package uz.gita.budget_app.domain

import uz.gita.budget_app.data.models.CalendarData
import uz.gita.budget_app.data.room.entity.CalendarEntity

// Created by Jamshid Isoqov an 10/14/2022
interface CalendarUseCase {

    suspend fun getStatisticsByDate(start: Long, end: Long): List<CalendarData>

    suspend fun insertCalendarData(calendarEntity: CalendarEntity)

    suspend fun updateCalendarData(calendarEntity: CalendarEntity)

    suspend fun deleteCalendarData(calendarEntity: CalendarEntity)

}