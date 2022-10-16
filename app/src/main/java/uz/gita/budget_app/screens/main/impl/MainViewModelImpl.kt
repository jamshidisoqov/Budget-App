package uz.gita.budget_app.screens.main.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.screens.main.MainIntent
import uz.gita.budget_app.screens.main.MainUiState
import uz.gita.budget_app.screens.main.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor() : MainViewModel, ViewModel() {

    override val container: Container<MainUiState, Nothing> = container(MainUiState.Input)

    override fun onEventDispatcher(intent: MainIntent) = intent {
        reduce {
            Log.d("YYY", "onEventDispatcher: $intent")
            when (intent) {
                MainIntent.InputClicked -> MainUiState.Input
                MainIntent.CalculatorClicked -> MainUiState.Calculator
                MainIntent.ReportClicked -> MainUiState.Report
                MainIntent.SettingsClicked -> MainUiState.Settings
            }
        }
    }
}