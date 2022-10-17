package uz.gita.budget_app.screens.main.report.monthly.intent_uistate

import java.io.Serializable

data class M_R_UiState(
    val monthData: String = "Loading",
    val currentBalance: Float = 0f,
    val incomeCount: Long = 0,
    val expenseCount: Long = 0,
    val previousBalance: Float = 0f,
    val monthlyReportList: List<Serializable> = emptyList()
)