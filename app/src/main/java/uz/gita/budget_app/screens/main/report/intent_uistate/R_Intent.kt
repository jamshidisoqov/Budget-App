package uz.gita.budget_app.screens.main.report.intent_uistate

sealed interface R_Intent{
    object MonthlyReport: R_Intent
    object CategoryReport: R_Intent
}