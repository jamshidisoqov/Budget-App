package uz.gita.budget_app.screens.main.report

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.screens.main.report.category_report.CategoryReportScreen
import uz.gita.budget_app.screens.main.report.monthly.MonthlyReportScreen
import uz.gita.budget_app.screens.main.report.pesenter.ReportScreenViewModel
import uz.gita.budget_app.screens.main.report.pesenter.impl.ReportScreenViewModelImpl
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.ui.theme.White


class ReportScreen : AndroidScreen(){

    @Composable
    override fun Content() {
        val viewModel: ReportScreenViewModel = getViewModel<ReportScreenViewModelImpl>()
        ReportScreenContent(viewModel = viewModel)
    }

}


@Composable
fun ReportScreenContent(
    viewModel: ReportScreenViewModel,
){

    val uiState = viewModel.collectAsState().value

    BudgetAppTheme {
        Surface {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(White)) {
                ReportBar(viewModel::onEventDispatcher)

                if (uiState.openedScreenId == 0){
                    MonthlyReportScreen().Content()
                }
                else
                    CategoryReportScreen().Content()
            }

        }
    }
}