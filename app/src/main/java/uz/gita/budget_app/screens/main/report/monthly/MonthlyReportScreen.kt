package uz.gita.budget_app.screens.main.report.monthly

import android.annotation.SuppressLint
import android.icu.text.ListFormatter.Width
import android.media.Image
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import uz.gita.budget_app.R
import uz.gita.budget_app.data.models.CalendarData
import uz.gita.budget_app.data.models.ExpansesData
import uz.gita.budget_app.data.models.IncomeData
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.ExpansesEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeEntity
import uz.gita.budget_app.ui.theme.BackgroundColor
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.ui.theme.Red
import uz.gita.budget_app.utils.AllCategoriesList
import uz.gita.budget_app.utils.Fonts
import java.io.Serializable

// Created by Jamshid Isoqov an 10/14/2022
class MonthlyReportScreen : AndroidScreen() {
    @Preview
    @Composable
    override fun Content() {
        BudgetAppTheme {
            Surface {
                Column() {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(state = ScrollState(1))) {
                        ReportBar()
                        DataSelectBar()
                        CurrentBalanceView()
                        ExpenseAndIncomeView()
                        PreviousBalanceView()

                    }
                    Column {
                        ReportTabsView()
                        MonthlyReportView()
                    }
                }


            }
        }
    }
}


@Composable
fun ReportBar() {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Month Report")
        Spacer(modifier = Modifier.weight(.7f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_expand_more_24),
                contentDescription = "Expand Button"
            )
        }
    }
}


@Composable
fun DataSelectBar() {
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
            onClick = { /*TODO*/ }, modifier = Modifier
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(50))
        ) {
            Image(
                painter = painterResource(id = R.drawable.navigate_before_24),
                contentDescription = "Navigate before",
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "February, 2022")
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /*TODO*/ }, modifier = Modifier
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
fun CurrentBalanceView() {
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
        Text(text = "Current Balance")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "$2133.23")
    }
}


@Composable
fun ExpenseAndIncomeView() {
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
            Text(text = "$2133.23")
        }
        Row {
            Text(text = "Expense")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$2133.23")
        }
    }

}


@Composable
fun PreviousBalanceView() {
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
            Text(text = "Expense/Income")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$2133.23")
        }
        Row {
            Text(text = "Previous Balance")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "$2133.23")
        }
    }

}


@Composable
fun ReportTabsView(
    text: String? = null,
    icon: Image? = null,
    selected: Boolean = false,
    onSelected: () -> Unit = {}
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
    //list: List<Serializable>
) {
    val list = listOf<Serializable>(
        CalendarData(4214123123, false, false),
        ExpansesData(
            ExpansesEntity(1, 2, 3, 323.0, 321.0, "For Holiday", 312312),
            ExpansesCategoryEntity(1, "Name", "sdasdasd")
            ),
        IncomeData(
            IncomeEntity(1, 2, 3, 323.0, 321.0, "For Holiday", 312312),
            IncomeCategoryEntity(1, "Name", "sdasdasd")
        ),
        CalendarData(4214123123, false, false),
        ExpansesData(
            ExpansesEntity(1, 2, 3, 323.0, 321.0, "For Holiday", 312312),
            ExpansesCategoryEntity(1, "Name", "sdasdasd")
        ),
        IncomeData(
            IncomeEntity(1, 2, 3, 323.0, 321.0, "For Holiday", 312312),
            IncomeCategoryEntity(1, "Name", "sdasdasd")
        )
    )
    LazyColumn {
        items(
            count = list.size,
            key = null,
            itemContent = { index ->
                when (list[index]) {
                    is CalendarData -> {
                        DayReportView()
                    }
                    is ExpansesData -> {
                        DayReportItemsView()
                    }
                    is IncomeData -> {
                        DayReportItemsView()
                    }
                }
            }
        )
    }
}


@Composable
fun DayReportView(
    //calendarData: CalendarData
) {
    Column(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .background(BackgroundColor)
            .height(48.dp)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Feb 24, 2022")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "-$4,232.34")
        }
        Spacer(modifier = Modifier.weight(.1f))
        Row(horizontalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "+$34,423.34")
        }
    }
}


@Composable
fun DayReportItemsView(

) {
    val category = AllCategoriesList.list.random()
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(42.dp)
            .background(Color.Unspecified),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = category.imageId),
            contentDescription = "Image",
            modifier = Modifier
                .padding(6.dp)
                .height(50.dp)
                .width(50.dp)
        )
        Text(text = category.name)
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "-$32.4", color = Red)
    }
}

