package uz.gita.budget_app.domain

import uz.gita.budget_app.data.room.entity.CategoryEntity

// Created by Jamshid Isoqov an 10/14/2022
interface SettingsUseCase {

    suspend fun getCurrentBalance(): Float

    suspend fun setCurrentBalance(balance: Float)

    suspend fun getPin(): String

    suspend fun setPin(pin: String)

    suspend fun getReminder(): String

    suspend fun setReminder(reminder: String)

    suspend fun getAllCategories(): List<CategoryEntity>

    suspend fun getIsDarkMode(): Boolean

    suspend fun setIsDarkMode()

}