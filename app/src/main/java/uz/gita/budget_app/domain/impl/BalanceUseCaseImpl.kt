package uz.gita.budget_app.domain.impl

import uz.gita.budget_app.domain.BalanceUseCase
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

class BalanceUseCaseImpl @Inject constructor(private val rep: BudgetRepository): BalanceUseCase {
    override suspend fun getCurrentBalance(): Float {
        return rep.getCurrentBalance()
    }
}