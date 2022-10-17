package uz.gita.budget_app.screens.main.report.monthly.intent_uistate

import java.io.Serializable

data class M_R_UiState(
    val monthData: String = "Loading",
    val currentBalance: Long = 0,
    val incomeCount: Long = 0,
    val expenseCount: Long = 0,
    val previousBalance: Long = 0,
    val monthlyReportList: List<Serializable> = emptyList()
)