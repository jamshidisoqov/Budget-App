package uz.gita.budget_app.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.models.ExpenseAndIncome

interface MonthlyReportUseCase {
    fun getAllMonthlyReports(): Flow<List<ExpenseAndIncome>>
}