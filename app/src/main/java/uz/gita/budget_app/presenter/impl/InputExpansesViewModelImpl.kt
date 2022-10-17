package uz.gita.budget_app.presenter.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.data.models.ExpansesData
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.ExpansesEntity
import uz.gita.budget_app.domain.CategoryUseCase
import uz.gita.budget_app.domain.CurrenciesUseCase
import uz.gita.budget_app.domain.ExpansesUseCase
import uz.gita.budget_app.navigation.AppNavigation
import uz.gita.budget_app.presenter.InputExpansesIntent
import uz.gita.budget_app.presenter.InputExpansesUiState
import uz.gita.budget_app.presenter.InputExpansesViewModel
import uz.gita.budget_app.screens.categories.add_category.AddCategoriesScreen
import javax.inject.Inject

@HiltViewModel
class InputExpansesViewModelImpl @Inject constructor(
    private val useCase: CategoryUseCase,
    private val expansesUiState: ExpansesUseCase,
    private val currenciesUseCase: CurrenciesUseCase,
    private val appNavigation: AppNavigation

    ) : InputExpansesViewModel, ViewModel() {
    override val container: Container<InputExpansesUiState, Nothing> =
        container(InputExpansesUiState.Success())


    init {
        viewModelScope.launch {
            useCase.getAllExpansesCategories().collectLatest { list ->
                intent {
                    reduce { InputExpansesUiState.Success(categoriesList = list) }
                }
            }
        }
    }

    override fun onEventDispatcher(intent: InputExpansesIntent) = intent {

        when (intent) {
            InputExpansesIntent.NextClicked -> {
                reduce {
                    val old = state as InputExpansesUiState.Success
                    old.copy(date = old.date + 86400000)
                }
            }
            InputExpansesIntent.PrevClicked -> {
                reduce {
                    val old = state as InputExpansesUiState.Success
                    old.copy(date = old.date - 86400000)
                }
            }
            is InputExpansesIntent.SubmitButtonClick -> {
                expansesUiState.insertExpansesEntity(
                    ExpansesData(
                        ExpansesEntity(
                            0,
                            currenciesUseCase.getCurrentCurrency().id,
                            expansesCategoryId = intent.categoryId,
                            currencyValue = intent.price,
                            currenciesUseCase.getCurrentCurrency().dollarPrice,
                            intent.comment,
                            intent.date
                        ), ExpansesCategoryEntity(intent.categoryId, "Name", 1)
                    )
                )
            }

            InputExpansesIntent.NavigateToAddCategory->{
                appNavigation.navigateTo(AddCategoriesScreen())
            }

        }
    }
}