package uz.gita.budget_app.screens.main.input.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.data.models.IncomeData
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeEntity
import uz.gita.budget_app.domain.CategoryUseCase
import uz.gita.budget_app.domain.CurrenciesUseCase
import uz.gita.budget_app.domain.IncomeUseCase
import uz.gita.budget_app.navigation.AppNavigation
import uz.gita.budget_app.screens.categories.add_category.AddCategoriesScreen
import uz.gita.budget_app.screens.main.input.InputIncomeIntent
import uz.gita.budget_app.screens.main.input.InputIncomeUiState
import uz.gita.budget_app.screens.main.input.InputIncomeViewModel
import javax.inject.Inject

@HiltViewModel
class InputIncomeViewModelImpl @Inject constructor(
    private val useCase: CategoryUseCase,
    private val incomeUseCase: IncomeUseCase,
    private val currenciesUseCase: CurrenciesUseCase,
    private val appNavigation: AppNavigation
) : InputIncomeViewModel, ViewModel() {

    override val container: Container<InputIncomeUiState, Nothing> =
        container(InputIncomeUiState.Success())

    init {
        viewModelScope.launch {
            useCase.getAllIncomeCategories().collectLatest { list ->
                intent {
                    reduce { InputIncomeUiState.Success(categoriesList = list) }
                }
            }
        }
    }

    override fun onEventDispatcher(intent: InputIncomeIntent) = intent {

        when (intent) {
            InputIncomeIntent.NextClicked -> {
                reduce {
                    val old = state as InputIncomeUiState.Success
                    old.copy(date = old.date + 86400000)
                }
            }
            InputIncomeIntent.PrevClicked -> {
                reduce {
                    val old = state as InputIncomeUiState.Success
                    old.copy(date = old.date - 86400000)
                }
            }
            is InputIncomeIntent.SubmitButtonClick -> {
                incomeUseCase.insertIncomeEntity(
                    IncomeData(
                        IncomeEntity(
                            0,
                            currenciesUseCase.getCurrentCurrency().id,
                            incomeCategoryId = intent.categoryId,
                            currencyValue = intent.price,
                            currenciesUseCase.getCurrentCurrency().dollarPrice,
                            intent.comment,
                            intent.date
                        ), IncomeCategoryEntity(intent.categoryId, "Name", 1)
                    )
                )
            }
            InputIncomeIntent.NavigateToAddCategory -> {
                appNavigation.navigateTo(AddCategoriesScreen())
            }
        }
    }
}