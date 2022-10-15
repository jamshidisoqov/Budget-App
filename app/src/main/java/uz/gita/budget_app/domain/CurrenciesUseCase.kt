package uz.gita.budget_app.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.CurrenciesEntity

// Created by Jamshid Isoqov an 10/14/2022
interface CurrenciesUseCase {

    suspend fun getCurrentCurrency(): CurrenciesEntity

    suspend fun setCurrentCurrency(currenciesEntity: CurrenciesEntity)

    suspend fun updateCurrencies(currenciesEntity: CurrenciesEntity)

    fun getAllCurrencies(): Flow<List<CurrenciesEntity>>

    suspend fun updateCurrencies(currenciesId: Int, currenciesDollarPrice: Double)

}