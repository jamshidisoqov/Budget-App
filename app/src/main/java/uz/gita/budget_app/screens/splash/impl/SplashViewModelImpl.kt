package uz.gita.budget_app.screens.splash.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.directions.IntroScreenDirections
import uz.gita.budget_app.directions.SplashScreenDirections
import uz.gita.budget_app.screens.splash.SplashViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val directions: SplashScreenDirections
) : SplashViewModel ,ViewModel(){

    init {
        viewModelScope.launch {
            delay(2000)
            directions.navigateToMainScreen()
        }
    }
    override fun onEventDispatcher(intent: Unit) {

    }
    override val container: Container<Unit, Nothing> = container(Unit)

}