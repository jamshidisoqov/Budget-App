package uz.gita.budget_app.domain

// Created by Jamshid Isoqov an 10/14/2022
interface SplashUseCase {

    suspend fun getRegisterThisApp(): Boolean

    suspend fun setRegisterThisApp()

}