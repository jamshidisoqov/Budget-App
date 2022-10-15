package uz.gita.budget_app.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.directions.SplashScreenDirections
import uz.gita.budget_app.domain.SplashUseCase
import uz.gita.budget_app.presenter.SplashViewModel
import javax.inject.Inject

class SplashViewModelImpl @Inject constructor(
    private val useCase: SplashUseCase,
    private val direction: SplashScreenDirections
) : SplashViewModel, ViewModel() {

    override fun onEventDispatcher(intent: Nothing) {}

    override val container: Container<Unit, Nothing> = container(Unit)

    init {
        viewModelScope.launch {
            if (useCase.getRegisterThisApp()) {
                direction.navigateToMainScreen()
            } else {
                useCase.setRegisterThisApp()
                direction.navigateToIntroScreen()
            }
        }
    }
}