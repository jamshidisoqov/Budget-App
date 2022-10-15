package uz.gita.budget_app.domain.impl

import uz.gita.budget_app.domain.SplashUseCase
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : SplashUseCase {
    override suspend fun getRegisterThisApp(): Boolean =
        repository.getRegisterThisApp()

    override suspend fun setRegisterThisApp() {
        repository.setRegisterThisApp()
    }
}