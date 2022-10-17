package uz.gita.budget_app.screens.main.report.category_report.presenter.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.directions.CategoryReportDirection
import uz.gita.budget_app.screens.main.report.category_report.intent_uistate.C_R_Intent
import uz.gita.budget_app.screens.main.report.category_report.intent_uistate.C_R_UiState
import uz.gita.budget_app.screens.main.report.category_report.presenter.CategoryReportViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryReportViewModelImpl @Inject constructor(
    //private val direction: CategoryReportDirection
) : CategoryReportViewModel, ViewModel() {

    val uiState = C_R_UiState()
    override fun onEventDispatcher(intent: C_R_Intent) = intent {
        when (intent) {
            is C_R_Intent.Back -> {}//direction.back()
            is C_R_Intent.OpenCategoryDetails -> {}//direction.navigateToCategoryReportDetails(uiState.categoryModel)
            is C_R_Intent.MonthAndWeekSelect -> reduce {
                state.copy(transactionReportByCategoryList = state.transactionReportByCategoryList)
            }
        }
    }

    override val container: Container<C_R_UiState, Nothing> = container(uiState)
}