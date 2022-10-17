package uz.gita.budget_app.data.models

data class DayReportModel (
    val data: Long,
    val incomeCount: Long,
    val expenseCount: Long,
): java.io.Serializable