package uz.gita.budget_app.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.R
import uz.gita.budget_app.screens.main.calculator.CalculatorScreen
import uz.gita.budget_app.screens.main.impl.MainViewModelImpl
import uz.gita.budget_app.screens.main.input.InputScreenContent
import uz.gita.budget_app.screens.main.report.ReportScreen
import uz.gita.budget_app.screens.main.report.monthly.MonthlyReportScreen
import uz.gita.budget_app.screens.main.settings.SettingsScreen
import uz.gita.budget_app.ui.theme.BackgroundColor

// Created by Jamshid Isoqov an 10/15/2022
class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        val viewModel: MainViewModel = getViewModel<MainViewModelImpl>()
        val uiState = viewModel.collectAsState().value
        MainScreenContent(uiState = uiState, eventDispatcher = viewModel::onEventDispatcher)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreenContent(uiState: MainUiState, eventDispatcher: (MainIntent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        var isSelected = 0
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            isSelected = when (uiState) {
                MainUiState.Input -> {
                    InputScreenContent()
                    1
                }
                MainUiState.Calculator -> {
                    CalculatorScreen().Content()
                    2
                }
                MainUiState.Report -> {
                    ReportScreen().Content()
                    3
                }
                MainUiState.Settings -> {
                    SettingsScreen().Content()
                    4
                }
            }
        }
        Row(
            modifier = Modifier
                .shadow(4.dp)
                .zIndex(1f)
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White)
        ) {
            BottomNavItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                imageRes = R.drawable.ic_input,
                name = "Input",
                isSelected = isSelected == 1
            ) {
                eventDispatcher.invoke(MainIntent.InputClicked)
            }

            BottomNavItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                imageRes = R.drawable.ic_calculator,
                name = "Calculator",
                isSelected = isSelected == 2
            ) {
                eventDispatcher.invoke(MainIntent.CalculatorClicked)
            }

            BottomNavItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                imageRes = R.drawable.ic_report,
                name = "Report",
                isSelected = isSelected == 3
            ) {
                eventDispatcher.invoke(MainIntent.ReportClicked)
            }

            BottomNavItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                imageRes = R.drawable.ic_settings,
                name = "Input",
                isSelected = isSelected == 4
            ) {
                eventDispatcher.invoke(MainIntent.SettingsClicked)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    MainScreenContent(uiState = MainUiState.Input, eventDispatcher = {})
}