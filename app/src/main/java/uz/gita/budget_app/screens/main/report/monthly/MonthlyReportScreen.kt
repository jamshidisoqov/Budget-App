package uz.gita.budget_app.screens.main.report.monthly

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.R
import uz.gita.budget_app.data.models.DayReportModel
import uz.gita.budget_app.data.models.ExpansesData
import uz.gita.budget_app.data.models.IncomeData
import uz.gita.budget_app.screens.main.report.ReportBar
import uz.gita.budget_app.screens.main.report.monthly.intent_uistate.M_R_Intents
import uz.gita.budget_app.screens.main.report.monthly.intent_uistate.M_R_UiState
import uz.gita.budget_app.screens.main.report.monthly.presenter.MonthlyReportViewModel
import uz.gita.budget_app.screens.main.report.monthly.presenter.impl.MonthlyReportViewModelImpl
import uz.gita.budget_app.ui.theme.BackgroundColor
import uz.gita.budget_app.ui.theme.Blue
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.ui.theme.Red
import uz.gita.budget_app.utils.Fonts
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

// Created by Jamshid Isoqov an 10/14/2022
class MonthlyReportScreen : AndroidScreen() {


    @Composable
    override fun Content() {
        val viewModel: MonthlyReportViewModel = getViewModel<MonthlyReportViewModelImpl>()
        MonthlyReportScreenContent(viewModel = viewModel)
    }
}


@Composable
fun MonthlyReportScreenContent(
    viewModel: MonthlyReportViewModel
){
    val uiState = viewModel.collectAsState().value
    BudgetAppTheme {
        Surface {
            Column() {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.verticalScroll(state = ScrollState(1))
                ) {

                    DataSelectBar(uiState, viewModel::onEventDispatcher)
                    CurrentBalanceView(uiState)
                    ExpenseAndIncomeView(uiState)
                    PreviousBalanceView(uiState)

                }
                Column {
                    ReportTabsView(viewModel::onEventDispatcher)
                    MonthlyReportView(uiState)
                }
            }


        }
    }
}

@Composable
fun DataSelectBar(
    uiState: M_R_UiState,
    eventDispatcher: (M_R_Intents) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .clip(RoundedCornerShape(50))
            .background(color = BackgroundColor)
            .padding(2.dp),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = {
                eventDispatcher(M_R_Intents.CalendarPrev)
            },
            modifier = Modifier
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(50))
        ) {
            Image(
                painter = painterResource(id = R.drawable.navigate_before_24),
                contentDescription = "Navigate before",
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Text(text = uiState.monthData)

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = { eventDispatcher(M_R_Intents.CalendarNext) },
            modifier = Modifier
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(50))
        ) {
            Image(
                painter = painterResource(id = R.drawable.navigate_next_24),
                contentDescription = "Navigate Next"
            )
        }
    }
}


@Composable
fun CurrentBalanceView(
    uiState: M_R_UiState
) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            .height(48.dp)
            .background(color = Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Current Balance",
            fontFamily = Fonts.poppinsFamily,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(modifier = Modifier.weight(1f))

        val numberFormat: NumberFormat =
            NumberFormat.getCurrencyInstance().apply {
                maximumFractionDigits = 0
            }
        val convert = numberFormat.format(uiState.currentBalance)
        Text(text = convert)
    }
}


@Composable
fun ExpenseAndIncomeView(
    uiState: M_R_UiState
) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            .height(84.dp)
            .background(color = Color.White)
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(text = "Income")
            Spacer(modifier = Modifier.weight(1f))

            val numberFormat: NumberFormat =
                NumberFormat.getCurrencyInstance().apply {
                    maximumFractionDigits = 0
                }
            val convert = numberFormat.format(uiState.incomeCount)
            Text(text = convert)
        }
        Row {
            Text(text = "Expense")
            Spacer(modifier = Modifier.weight(1f))

            val numberFormat: NumberFormat =
                NumberFormat.getCurrencyInstance().apply {
                    maximumFractionDigits = 0
                }
            val convert = numberFormat.format(uiState.expenseCount)
            Text(text = convert)
        }
    }

}


@Composable
fun PreviousBalanceView(
    uiState: M_R_UiState
) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp))
            .height(84.dp)
            .background(color = Color.White)
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {

            val numberFormat: NumberFormat =
                NumberFormat.getCurrencyInstance().apply {
                    maximumFractionDigits = 0
                }
            val convert = numberFormat.format(uiState.incomeCount-uiState.expenseCount)

            Text(text = "Expense/Income")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = convert)
        }
        Row {

            val numberFormat: NumberFormat =
                NumberFormat.getCurrencyInstance().apply {
                    maximumFractionDigits = 0
                }
            val convert = numberFormat.format(uiState.previousBalance)

            Text(text = "Previous Balance")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = convert)
        }
    }

}


@Composable
fun ReportTabsView(
    eventDispatcher: (M_R_Intents) -> Unit
) {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("All", "Expense", "Income")
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            )
            .height(48.dp)
            .width(300.dp)
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        TabRow(selectedTabIndex = state, divider = {}) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = {
                        state = index
                        eventDispatcher(M_R_Intents.ReportTabSelected(index))
                    },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray
                )
            }
        }
    }
}


@Composable
fun MonthlyReportView(
    uiState: M_R_UiState
) {

    LazyColumn {
        items(
            count = uiState.monthlyReportList.size,
            key = null,
            itemContent = { index ->

                val report = uiState.monthlyReportList[index]

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



@Composable
fun DayReportView(
    dayReportModel: DayReportModel
) {

    val dateS = Date(dayReportModel.data)
    val date = SimpleDateFormat.getDateInstance().format("MMM dd, yyyy").format(dateS)


    Column(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .background(BackgroundColor)
            .height(48.dp)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = date)
            Spacer(modifier = Modifier.weight(1f))

            val numberFormat: NumberFormat =
                NumberFormat.getCurrencyInstance().apply {
                    maximumFractionDigits = 0
                }
            val convert = numberFormat.format(dayReportModel.expenseCount)
            Text(text = convert)
        }
        Spacer(modifier = Modifier.weight(.1f))
        Row(horizontalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(1f))

            val numberFormat: NumberFormat =
                NumberFormat.getCurrencyInstance().apply {
                    maximumFractionDigits = 0
                }
            val convert = numberFormat.format(dayReportModel.incomeCount)
            Text(text = convert)
        }
    }
}


@Composable
fun DayReportItemsView(
    expansesData: ExpansesData? = null,
    incomeData: IncomeData? = null
) {
    var imageId : Int = R.raw.money
    val name: String
    val amount: String

    if (expansesData != null) {
        imageId = expansesData.category.image

        name = expansesData.category.name

        val value = expansesData.expansesEntity.currencyValue
        val numberFormat: NumberFormat =
            NumberFormat.getCurrencyInstance().apply {
                maximumFractionDigits = 0
            }
        amount = "-" + numberFormat.format(value)
    }
    else if (incomeData != null){
        imageId = incomeData.category.image
        name = incomeData.category.name
        val value = incomeData.incomeEntity.currencyValue
        val numberFormat: NumberFormat =
            NumberFormat.getCurrencyInstance().apply {
                maximumFractionDigits = 0
            }
        amount = "+" + numberFormat.format(value)
    }
    else
        return

    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(42.dp)
            .background(Color.Unspecified),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Image",
            modifier = Modifier
                .padding(6.dp)
                .height(50.dp)
                .width(50.dp)
        )
        Text(text = name)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = amount, color = if (amount.startsWith('-')) Red else Blue)
    }
}

