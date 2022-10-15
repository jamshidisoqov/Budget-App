package uz.gita.budget_app.screens.main

// Created by Jamshid Isoqov an 10/15/2022
sealed interface MainUiState {
    object Input : MainUiState
    object Calculator : MainUiState
    object Report : MainUiState
    object Settings : MainUiState
}