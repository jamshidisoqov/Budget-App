package uz.gita.budget_app.screens.categories.add_category.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.domain.CategoryUseCase
import uz.gita.budget_app.navigation.AppNavigation
import uz.gita.budget_app.screens.categories.add_category.AddCategoryIntent
import uz.gita.budget_app.screens.categories.add_category.AddCategoryUiState
import uz.gita.budget_app.screens.categories.add_category.AddCategoryViewModel
import uz.gita.budget_app.screens.categories.edit_categories.EditCategoriesScreen
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModelImpl @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
    private val appNavigation: AppNavigation
) : AddCategoryViewModel, ViewModel() {
    override val container: Container<AddCategoryUiState, Nothing> =
        container(AddCategoryUiState.Success())

    init {
        viewModelScope.launch {
            categoryUseCase.getAllIncomeCategories().collectLatest { list ->
                intent {
                    reduce {
                        (state as AddCategoryUiState.Success).copy(incomeList = list)
                    }
                }
            }
            categoryUseCase.getAllExpansesCategories().collectLatest { list ->
                intent {
                    reduce {
                        (state as AddCategoryUiState.Success).copy(expanseList = list)
                    }
                }
            }
        }
    }

    override fun onEventDispatcher(intent: AddCategoryIntent) = intent {
        when (intent) {
            AddCategoryIntent.Back -> {
                appNavigation.back()
            }
            AddCategoryIntent.Remove -> {

            }
            is AddCategoryIntent.EditCategory -> {
                appNavigation.navigateTo(EditCategoriesScreen(intent.type))
            }
        }
    }
}