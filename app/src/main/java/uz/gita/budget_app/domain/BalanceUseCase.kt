package uz.gita.budget_app.domain

interface BalanceUseCase {
    suspend fun getCurrentBalance(): Float
}