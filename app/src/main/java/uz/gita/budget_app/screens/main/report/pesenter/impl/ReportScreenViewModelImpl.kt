package uz.gita.budget_app.screens.main.report.pesenter.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.screens.main.report.intent_uistate.R_Intent
import uz.gita.budget_app.screens.main.report.intent_uistate.R_UiState
import uz.gita.budget_app.screens.main.report.pesenter.ReportScreenViewModel
import javax.inject.Inject

@HiltViewModel
class ReportScreenViewModelImpl @Inject constructor() : ReportScreenViewModel, ViewModel(){

    private val uiState = R_UiState()
    override fun onEventDispatcher(intent: R_Intent) = intent{
        when(intent){
            is R_Intent.CategoryReport -> reduce{
                state.copy(openedScreenId = 1)
            }
            is R_Intent.MonthlyReport -> reduce{
                state.copy(openedScreenId = 0)
            }
        }
    }

    override val container: Container<R_UiState, Nothing> = container(uiState)
}