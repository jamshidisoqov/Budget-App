package uz.gita.budget_app.screens.main.report.monthly.presenter.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.screens.main.report.monthly.intent_uistate.M_R_Intents
import uz.gita.budget_app.screens.main.report.monthly.intent_uistate.M_R_UiState
import uz.gita.budget_app.screens.main.report.monthly.presenter.MonthlyReportViewModel
import javax.inject.Inject

@HiltViewModel
class MonthlyReportViewModelImpl @Inject constructor() : MonthlyReportViewModel, ViewModel() {

    val uiState = M_R_UiState()
    override fun onEventDispatcher(intent: M_R_Intents) = intent {
        when(intent){
            is M_R_Intents.CalendarNext -> //reduce
            {

            }
            is M_R_Intents.CalendarPrev -> //reduce
            {

            }
            is M_R_Intents.ReportTabSelected -> //reduce
            {

            }
        }
    }

    override val container: Container<M_R_UiState, Nothing> = container(uiState)
}