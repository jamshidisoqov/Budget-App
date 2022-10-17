package uz.gita.budget_app.domain.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.models.ExpenseAndIncome
import uz.gita.budget_app.domain.MonthlyReportUseCase
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

//class MonthlyReportUseCaseImpl @Inject constructor(private val rep : BudgetRepository): MonthlyReportUseCase {
//    override fun getAllMonthlyReports(): Flow<List<ExpenseAndIncome>> = rep.getAllCategories()
//}