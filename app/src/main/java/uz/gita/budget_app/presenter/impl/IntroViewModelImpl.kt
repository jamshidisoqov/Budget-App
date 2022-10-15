package uz.gita.budget_app.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.directions.IntroScreenDirections
import uz.gita.budget_app.presenter.Intent
import uz.gita.budget_app.presenter.IntroScreenViewModel
import javax.inject.Inject


@HiltViewModel
class IntroScreenViewModelImpl @Inject constructor(
    private val direction: IntroScreenDirections
) : IntroScreenViewModel, ViewModel() {

    override fun onEventDispatcher(intent: Intent) = intent {

        reduce {
            viewModelScope.launch {
                direction.navigateToMainScreen()
            }
        }
    }

    override val container: Container<Unit, Nothing> = container(Unit)
}