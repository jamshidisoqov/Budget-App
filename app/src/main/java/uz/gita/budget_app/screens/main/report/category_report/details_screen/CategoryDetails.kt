package uz.gita.budget_app.screens.main.report.category_report.details_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.data.models.DayReportModel
import uz.gita.budget_app.data.models.ExpansesData
import uz.gita.budget_app.data.models.IncomeData
import uz.gita.budget_app.screens.main.report.category_report.intent_uistate.C_R_Intent
import uz.gita.budget_app.screens.main.report.category_report.intent_uistate.C_R_UiState
import uz.gita.budget_app.screens.main.report.category_report.presenter.CategoryReportViewModel
import uz.gita.budget_app.screens.main.report.category_report.presenter.impl.CategoryReportViewModelImpl
import uz.gita.budget_app.screens.main.report.monthly.DayReportItemsView
import uz.gita.budget_app.screens.main.report.monthly.DayReportView
import uz.gita.budget_app.screens.main.report.monthly.MonthlyReportView
import uz.gita.budget_app.screens.main.report.monthly.intent_uistate.M_R_UiState
import uz.gita.budget_app.ui.theme.*
import uz.gita.budget_app.utils.Fonts


// Created by Jamshid Isoqov an 10/14/2022\


class CategoryDetails : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel : CategoryReportViewModel = getViewModel<CategoryReportViewModelImpl>()
        CategoryDetailsContent(viewModel = viewModel)
    }

}

@Composable
fun CategoryDetailsContent(
    viewModel: CategoryReportViewModel
){
    val uiState = viewModel.collectAsState().value
    BudgetAppTheme {
        Surface (color = Color.White) {
            Column(modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ActionBarView(viewModel::onEventDispatcher)
                MonthAndWeekTab(viewModel::onEventDispatcher)
                CategoryItem(uiState)
                MonthlyReportByCategoryView(uiState)
            }

        }
    }
}



@Composable
fun ActionBarView(
   eventDispatcher: (C_R_Intent) -> Unit
) {
    BudgetAppTheme() {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            TextButton(
                onClick = { eventDispatcher(C_R_Intent.Back) },
                modifier = Modifier.align(Alignment.CenterStart),
            ) {
                Text(text = "back", color = SecondaryColor)
            }

            Text(
                text = "Category Report",
                modifier = Modifier.align(Alignment.Center),
                color = PrimaryColor
            )
        }
    }

}


@Composable
fun MonthAndWeekTab(

    eventDispatcher: (C_R_Intent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {

        var selectedIndex by remember { mutableStateOf(0) }

        val list = listOf("Month", "Week")

        TabRow(selectedTabIndex = selectedIndex,
            contentColor = PrimaryColor,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .clip(RoundedCornerShape(50))
                .background(Color.White)
                .border(width = 3.dp, color = BackgroundColor, RoundedCornerShape(50))
                .border(width = 1.dp, color = Color.Gray, RoundedCornerShape(50)),
            indicator = { tabPositions: List<TabPosition> ->
                //Box (modifier = Modifier.background(Color.Unspecified)){}
                TabRowDefaults.Indicator(
                    color = Color.Transparent
                )
            }
        ) {
            list.forEachIndexed { index, text ->
                val selected = selectedIndex == index
                val cornerShape =
                    if (index == 0) RoundedCornerShape(
                        topStartPercent = 50,
                        bottomStartPercent = 50
                    )
                    else RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50)
                val selectedColor = if (selected) PrimaryColor else SecondaryColor
                val modifier =
                    if (selected)
                        Modifier
                            .padding(4.dp)
                            .background(
                                BackgroundColor, cornerShape
                            )
                    else
                        Modifier
                            .padding(4.dp)
                            .background(
                                White, cornerShape
                            )


                Tab(
                    modifier = modifier,
                    selected = selected,
                    onClick = {
                        selectedIndex = index
                        eventDispatcher(C_R_Intent.MonthAndWeekSelect(index))
                              },
                    text = { Text(text = text, color = selectedColor) }
                )
            }
        }

    }


}



@SuppressLint("ResourceType")
@Composable
fun CategoryItem(
    uiState: C_R_UiState,
) {

    val imageId = uiState.categoryModel.imageId
    val name = uiState.categoryModel.name

    Column(
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(60.dp))
            .width(300.dp)
            .height(300.dp)
            .background(ExpenseBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageId), contentDescription = "Image",
            modifier = Modifier.size(200.dp),
            colorFilter = ColorFilter.tint(Expense)
        )
        Text(
            text = name, fontFamily = Fonts.poppinsFamily,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleLarge,
            color = SecondaryColor
        )
    }
}


@Composable
fun MonthlyReportByCategoryView(
    uiState: C_R_UiState
) {

    LazyColumn {
        items(
            count = uiState.transactionReportByCategoryList.size,
            key = null,
            itemContent = { index ->

                val report = uiState.transactionReportByCategoryList[index]

                when (report) {
                    is DayReportModel -> {
                        DayReportView(report )
                    }
                    is ExpansesData -> {
                        DayReportItemsView(expansesData = report)
                    }
                    is IncomeData -> {
                        DayReportItemsView(incomeData = report)
                    }
                }
            }
        )
    }
}