package uz.gita.budget_app.screens.main.calculator

import Calculator
import CalculatorViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.androidx.AndroidScreen
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import uz.gita.budget_app.R
import uz.gita.budget_app.ui.theme.BackgroundColor
import uz.gita.budget_app.ui.theme.BudgetAppTheme
import uz.gita.budget_app.ui.theme.White


class CalculatorScreen:AndroidScreen() {
    @Composable
    override fun Content() {
            val viewModel = viewModel<CalculatorViewModel>()
            val state = viewModel.state
            val buttonSpacing = 8.dp
            Calculator(
                state = state,
                onAction = viewModel::onAction,
                buttonSpacing = buttonSpacing,
                modifier = Modifier
                    .fillMaxSize()
                    .background(BackgroundColor)
                    .padding(16.dp)
            )
        }
    }
