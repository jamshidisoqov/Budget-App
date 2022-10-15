package uz.gita.budget_app.screens.main

// Created by Jamshid Isoqov an 10/15/2022
sealed interface MainIntent {
    object InputClicked : MainIntent
    object CalculatorClicked : MainIntent
    object ReportClicked : MainIntent
    object SettingsClicked : MainIntent
}