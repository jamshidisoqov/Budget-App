package uz.gita.budget_app.directions

interface SplashScreenDirections {

    suspend fun navigateToIntroScreen()

    suspend fun navigateToPinScreen()

    suspend fun navigateToMainScreen()
}