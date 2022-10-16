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
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.budget_app.R
import uz.gita.budget_app.screens.main.impl.MainViewModelImpl
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

@Composable
fun MainScreenContent(uiState: MainUiState, eventDispatcher: (MainIntent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        val isSelected = when (uiState) {
            MainUiState.Input -> {
                1
            }
            MainUiState.Calculator -> {
                2
            }
            MainUiState.Report -> {
                3
            }
            MainUiState.Settings -> {
                4
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {}
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

@Preview
@Composable
fun MainScreenPreview() {
    MainScreenContent(uiState = MainUiState.Input, eventDispatcher = {})
}