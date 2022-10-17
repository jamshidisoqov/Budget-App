package uz.gita.budget_app.screens.categories.edit_categories.impl

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.domain.CategoryUseCase
import uz.gita.budget_app.screens.categories.edit_categories.EditCategoryIntent
import uz.gita.budget_app.screens.categories.edit_categories.EditCategoryViewModel
import javax.inject.Inject

@HiltViewModel
class EditCategoryViewModelImpl @Inject constructor(
    private val useCase: CategoryUseCase
) : EditCategoryViewModel, ViewModel() {
    override val container: Container<Unit, Nothing> = container(Unit)

    override fun onEventDispatcher(intent: EditCategoryIntent) = intent {
        when (intent) {
            is EditCategoryIntent.AddClick -> {
                if (intent.type == 1) {
                    useCase.insertIncomeCategory(
                        IncomeCategoryEntity(
                            0,
                            intent.categoryModel.name,
                            intent.categoryModel.imageId
                        )
                    )
                } else {
                    useCase.insertExpansesCategory(
                        ExpansesCategoryEntity(
                            0,
                            intent.categoryModel.name,
                            intent.categoryModel.imageId
                        )
                    )
                }
            }
        }
    }
}