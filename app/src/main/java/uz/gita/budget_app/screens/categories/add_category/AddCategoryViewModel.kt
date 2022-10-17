package uz.gita.budget_app.screens.categories.add_category

import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.utils.AppViewModel

// Created by Jamshid Isoqov an 10/17/2022
interface AddCategoryViewModel : AppViewModel<AddCategoryIntent, AddCategoryUiState, Nothing>

sealed interface AddCategoryIntent {
    object Back : AddCategoryIntent
    object Remove : AddCategoryIntent
    data class EditCategory(val type: Int):AddCategoryIntent
}

sealed interface AddCategoryUiState {

    data class Success(
        val incomeList: List<IncomeCategoryEntity> = emptyList(),
        val expanseList: List<ExpansesCategoryEntity> = emptyList()
    ) : AddCategoryUiState

}