package uz.gita.budget_app.domain.impl

import uz.gita.budget_app.data.models.CalendarData
import uz.gita.budget_app.data.room.entity.CalendarEntity
import uz.gita.budget_app.domain.CalendarUseCase
import uz.gita.budget_app.repository.BudgetRepository
import uz.gita.budget_app.utils.getDateFormat
import java.util.*
import javax.inject.Inject

class CalendarUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : CalendarUseCase {
    override suspend fun getStatisticsByDate(start: Long, end: Long): List<CalendarData> {
        val calendarList = ArrayList<CalendarData>()
        var startDate = start
        while (startDate <= end) {
            val data = getDateFormat(Date(startDate))
            val isExpanse = repository.calendarOfExistsDateExpanses(data) != null
            val isIncome = repository.calendarOfExistsDateIncome(data) != null
            calendarList.add(CalendarData(startDate, isExpanse, isIncome))
            startDate += 86400000
        }
        return calendarList
    }

    override suspend fun insertCalendarData(calendarEntity: CalendarEntity) {
        repository.insertCalendarData(calendarEntity)
    }

    override suspend fun updateCalendarData(calendarEntity: CalendarEntity) {
        repository.updateCalendarData(calendarEntity)
    }

    override suspend fun deleteCalendarData(calendarEntity: CalendarEntity) {
        repository.deleteCalendarData(calendarEntity)
    }
}