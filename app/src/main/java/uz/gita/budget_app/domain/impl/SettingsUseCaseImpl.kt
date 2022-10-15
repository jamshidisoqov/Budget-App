package uz.gita.budget_app.domain.impl

import uz.gita.budget_app.data.room.entity.CategoryEntity
import uz.gita.budget_app.domain.SettingsUseCase
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

class SettingsUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : SettingsUseCase {

    override suspend fun getCurrentBalance(): Float = repository.getCurrentBalance()

    override suspend fun setCurrentBalance(balance: Float) = repository.setCurrentBalance(balance)

    override suspend fun getPin(): String = repository.getPin()

    override suspend fun setPin(pin: String) {
        repository.setPin(pin)
    }

    override suspend fun getReminder(): String = repository.getReminder()

    override suspend fun setReminder(reminder: String) {
        repository.setReminder(reminder)
    }

    override suspend fun getAllCategories(): List<CategoryEntity> = repository.getAllCategories()

    override suspend fun getIsDarkMode(): Boolean = repository.getIsDarkMode()

    override suspend fun setIsDarkMode() {
        repository.setIsDarkMode()
    }
}