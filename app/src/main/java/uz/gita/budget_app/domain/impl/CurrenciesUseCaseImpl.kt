package uz.gita.budget_app.domain.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.CurrenciesEntity
import uz.gita.budget_app.domain.CurrenciesUseCase
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

class CurrenciesUseCaseImpl @Inject constructor(
    private val repository: BudgetRepository
) : CurrenciesUseCase {
    override suspend fun getCurrentCurrency(): CurrenciesEntity = repository.getCurrentCurrency()

    override suspend fun setCurrentCurrency(currenciesEntity: CurrenciesEntity) {
        repository.setCurrentCurrency(currenciesEntity)
    }

    override suspend fun updateCurrencies(currenciesEntity: CurrenciesEntity) {
        repository.updateCurrencies(currenciesEntity)
    }

    override fun getAllCurrencies(): Flow<List<CurrenciesEntity>> = repository.getAllCurrencies()

    override suspend fun updateCurrencies(currenciesId: Int, currenciesDollarPrice: Double) {
        repository.updateCurrencies(currenciesId, currenciesDollarPrice)
    }
}