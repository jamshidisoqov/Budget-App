package uz.gita.budget_app.screens.main.input

import uz.gita.budget_app.data.room.entity.IncomeCategoryEntity
import uz.gita.budget_app.utils.AppViewModel
import uz.gita.budget_app.utils.getCurrentDate
import uz.gita.budget_app.utils.toDate

// Created by Jamshid Isoqov an 10/16/2022
interface InputIncomeViewModel : AppViewModel<InputIncomeIntent, InputIncomeUiState, Nothing>


sealed interface InputIncomeUiState {
    data class Success(
        val date: Long = getCurrentDate().toDate().time,
        val categoriesList: List<IncomeCategoryEntity> = emptyList()
    ) : InputIncomeUiState
}

sealed interface InputIncomeIntent {
    data class SubmitButtonClick(
        val price: Double,
        val date: Long,
        val comment: String,
        val categoryId: Int
    ) : InputIncomeIntent

    object PrevClicked : InputIncomeIntent

    object NextClicked : InputIncomeIntent

    object NavigateToAddCategory : InputIncomeIntent
}