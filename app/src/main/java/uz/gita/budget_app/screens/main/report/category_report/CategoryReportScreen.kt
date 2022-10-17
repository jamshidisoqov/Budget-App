package uz.gita.budget_app.screens.main.report.category_report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.screens.main.report.ReportBar
import uz.gita.budget_app.screens.main.report.category_report.intent_uistate.C_R_Intent
import uz.gita.budget_app.screens.main.report.category_report.intent_uistate.C_R_UiState
import uz.gita.budget_app.screens.main.report.category_report.presenter.CategoryReportViewModel
import uz.gita.budget_app.screens.main.report.category_report.presenter.impl.CategoryReportViewModelImpl
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.utils.CategoryItemView
import uz.gita.budget_app.utils.Fonts

// Created by Jamshid Isoqov an 10/14/2022
class CategoryReportScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel : CategoryReportViewModel = getViewModel<CategoryReportViewModelImpl>()
        CategoryReportScreenContent(viewModel = viewModel)
    }

}


@Composable
fun CategoryReportScreenContent(
    viewModel: CategoryReportViewModel
){
    val uiState = viewModel.collectAsState().value
    BudgetAppTheme {
        Surface {
            Column(modifier = Modifier.fillMaxSize()) {

                CategoriesView(
                    uiState, viewModel::onEventDispatcher
                )
            }

        }
    }
}

@Composable
fun CategoriesView(
    uiState: C_R_UiState,
    eventDispatcher: (C_R_Intent) -> Unit
) {


    val cols = 4
    LazyVerticalGrid(
        horizontalArrangement = Arrangement.Center,
        columns = GridCells.Fixed(cols)
    ) {
        item(span = { GridItemSpan(cols) }) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Expense",
                fontFamily = Fonts.poppinsFamily,
                fontWeight = FontWeight.Normal
            )
        }

        items(uiState.expenseItems) {
            CategoryItemView(it) {
                eventDispatcher(C_R_Intent.OpenCategoryDetails(it))
            }
        }

        item(span = { GridItemSpan(cols) }) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Income",
                fontFamily = Fonts.poppinsFamily,
                fontWeight = FontWeight.Normal
            )
        }

        items(uiState.incomeItems) {
            CategoryItemView(it){
                eventDispatcher(C_R_Intent.OpenCategoryDetails(it))
            }
        }
    }
}