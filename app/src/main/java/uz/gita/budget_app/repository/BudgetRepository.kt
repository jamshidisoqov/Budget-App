package uz.gita.budget_app.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.room.entity.*

// Created by Jamshid Isoqov an 10/14/2022
interface BudgetRepository {
    //calendar screen
    suspend fun insertCalendarData(calendarEntity: CalendarEntity)

    suspend fun updateCalendarData(calendarEntity: CalendarEntity)

    suspend fun deleteCalendarData(calendarEntity: CalendarEntity)

    suspend fun calendarOfExistsDateExpanses(date: String): CalendarEntity?

    suspend fun calendarOfExistsDateIncome(date: String): CalendarEntity?

    //splash screen
    suspend fun getRegisterThisApp(): Boolean

    suspend fun setRegisterThisApp()

    //currencies
    suspend fun getCurrentCurrency(): CurrenciesEntity

    suspend fun setCurrentCurrency(currenciesEntity: CurrenciesEntity)

    suspend fun updateCurrencies(currenciesEntity: CurrenciesEntity)

    fun getAllCurrencies(): Flow<List<CurrenciesEntity>>

    suspend fun updateCurrencies(currenciesId: Int, currenciesDollarPrice: Double)

    //expanses category
    fun getAllExpansesCategories(): Flow<List<ExpansesCategoryEntity>>

    suspend fun getExpansesCategoryById(expanseId: Int): ExpansesCategoryEntity

    suspend fun insertExpansesCategory(entity: ExpansesCategoryEntity)

    suspend fun updateExpansesCategory(entity: ExpansesCategoryEntity)

    suspend fun deleteExpansesCategory(entity: ExpansesCategoryEntity)

    //income category

    fun getAllIncomeCategories(): Flow<List<IncomeCategoryEntity>>

    suspend fun getIncomeCategoryById(incomeId: Int): IncomeCategoryEntity

    suspend fun insertIncomeCategory(entity: IncomeCategoryEntity)

    suspend fun updateIncomeCategory(entity: IncomeCategoryEntity)

    suspend fun deleteIncomeCategory(entity: IncomeCategoryEntity)


    //expanses
    suspend fun insertExpansesEntity(expansesEntity: ExpansesEntity):Long

    suspend fun updateExpansesEntity(expansesEntity: ExpansesEntity):Int

    suspend fun deleteExpansesEntity(expansesEntity: ExpansesEntity)

    fun getAllExpansesByDate(start: Long, end: Long): Flow<List<ExpansesEntity>>

    suspend fun getExpansesSumByDate(start: Long, end: Long): Double

    fun getAllExpansesByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<ExpansesEntity>>

    suspend fun getExpansesSumByCategoryDate(categoryId: Int, start: Long, end: Long): Double

    //income
    suspend fun insertIncomeEntity(entity: IncomeEntity):Long

    suspend fun updateIncomeEntity(entity: IncomeEntity):Int

    suspend fun deleteIncomeEntity(entity: IncomeEntity)

    fun getAllIncomeByDate(start: Long, end: Long): Flow<List<IncomeEntity>>

    suspend fun getIncomesSumByDate(start: Long, end: Long): Double

    fun getAllIncomeByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<IncomeEntity>>

    suspend fun getIncomesSumByCategoryDate(categoryId: Int, start: Long, end: Long): Double

    //images
    suspend fun insertImagesEntity(imagesEntity: ImagesEntity)

    suspend fun updateImagesEntity(imagesEntity: ImagesEntity)

    suspend fun deleteImagesEntity(imagesEntity: ImagesEntity)

    suspend fun getAllExpansesImages(expansesId: Int): List<ImagesEntity>

    suspend fun getAllIncomeImages(incomeId: Int): List<ImagesEntity>

    //current balance
    suspend fun getCurrentBalance(): Float

    suspend fun setCurrentBalance(balance: Float)

    //settings
    suspend fun getPin(): String

    suspend fun setPin(pin: String)

    suspend fun getReminder(): String

    suspend fun setReminder(reminder: String)

    suspend fun getAllCategories():List<CategoryEntity>

    suspend fun getIsDarkMode(): Boolean

    suspend fun setIsDarkMode()
}