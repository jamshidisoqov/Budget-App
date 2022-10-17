package uz.gita.budget_app.screens.main.report.monthly.intent_uistate

sealed interface M_R_Intents {
    object CalendarNext : M_R_Intents
    object CalendarPrev : M_R_Intents
    class ReportTabSelected(val tabIndex : Int) : M_R_Intents
}
