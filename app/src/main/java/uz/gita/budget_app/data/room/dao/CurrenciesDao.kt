package uz.gita.budget_app.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.CurrenciesEntity

// Created by Jamshid Isoqov an 10/14/2022

@Dao
interface CurrenciesDao : BaseDao<CurrenciesEntity> {

    @Query("select*from currencies")
    fun getAllCurrencies(): Flow<List<CurrenciesEntity>>

    @Query("update currencies set dollarPrice=:currenciesDollarPrice where id=:currenciesId")
    suspend fun updateCurrencies(currenciesId: Int, currenciesDollarPrice: Double)

}