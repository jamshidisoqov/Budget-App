package uz.gita.budget_app.directions.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.budget_app.directions.SplashScreenDirections
import uz.gita.budget_app.navigation.AppNavigation
import uz.gita.budget_app.screens.intro.IntroScreen
import uz.gita.budget_app.screens.main.MainScreen
import uz.gita.budget_app.screens.pin.PinScreen
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val appNavigation: AppNavigation
) : SplashScreenDirections, ViewModel() {

    init {
        viewModelScope.launch {

        }
    }

    override suspend fun navigateToIntroScreen() {
        appNavigation.splashNavigateTo(IntroScreen())
    }

    override suspend fun navigateToPinScreen() {
        appNavigation.splashNavigateTo(PinScreen())
    }

    override suspend fun navigateToMainScreen() {
        appNavigation.splashNavigateTo(MainScreen())
    }
}