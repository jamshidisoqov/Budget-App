package uz.gita.budget_app.presenter

import uz.gita.budget_app.data.room.entity.ExpansesCategoryEntity
import uz.gita.budget_app.utils.AppViewModel
import uz.gita.budget_app.utils.getCurrentDate
import uz.gita.budget_app.utils.toDate

// Created by Jamshid Isoqov an 10/17/2022
interface InputExpansesViewModel : AppViewModel<InputExpansesIntent, InputExpansesUiState, Nothing>


sealed interface InputExpansesUiState {
    data class Success(
        val date: Long = getCurrentDate().toDate().time,
        val categoriesList: List<ExpansesCategoryEntity> = emptyList()
    ) : InputExpansesUiState
}

sealed interface InputExpansesIntent {
    data class SubmitButtonClick(
        val price: Double,
        val date: Long,
        val comment: String,
        val categoryId: Int
    ) : InputExpansesIntent

    object NavigateToAddCategory : InputExpansesIntent

    object PrevClicked : InputExpansesIntent

    object NextClicked : InputExpansesIntent
}