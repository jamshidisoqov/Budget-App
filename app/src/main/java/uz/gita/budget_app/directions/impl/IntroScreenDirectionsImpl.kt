package uz.gita.budget_app.directions.impl

import uz.gita.budget_app.directions.IntroScreenDirections
import uz.gita.budget_app.navigation.AppNavigation
import uz.gita.budget_app.screens.main.MainScreen
import javax.inject.Inject

class IntroScreenDirectionsImpl @Inject constructor(
    private val appNavigation: AppNavigation
) : IntroScreenDirections {
    override suspend fun navigateToMainScreen() {
        appNavigation.navigateTo(MainScreen())
    }
}