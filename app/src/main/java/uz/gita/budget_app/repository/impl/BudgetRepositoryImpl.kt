package uz.gita.budget_app.repository.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.budget_app.data.api.CBUApi
import uz.gita.budget_app.data.models.CBUData
import uz.gita.budget_app.data.prefs.MySharedPref
import uz.gita.budget_app.data.room.dao.*
import uz.gita.budget_app.data.room.entity.*
import uz.gita.budget_app.repository.BudgetRepository
import javax.inject.Inject

class BudgetRepositoryImpl @Inject constructor(
    private val calendarDao: CalendarDao,
    private val categoriesDao: CategoriesDao,
    private val currenciesDao: CurrenciesDao,
    private val expansesCategoryDao: ExpansesCategoryDao,
    private val expansesDao: ExpansesDao,
    private val imagesDao: ImagesDao,
    private val incomeCategoryDao: IncomeCategoryDao,
    private val incomeDao: IncomeDao,
    private val mySharedPref: MySharedPref,
    private val api:CBUApi
) : BudgetRepository {

    override suspend fun insertCalendarData(calendarEntity: CalendarEntity) {
        calendarDao.insert(calendarEntity)
    }

    override suspend fun updateCalendarData(calendarEntity: CalendarEntity) {
        calendarDao.update(calendarEntity)
    }

    override suspend fun deleteCalendarData(calendarEntity: CalendarEntity) =
        calendarDao.delete(calendarEntity)

    override suspend fun calendarOfExistsDateExpanses(date: String): CalendarEntity? =
        calendarDao.calendarOfExistsDateExpanses(date)

    override suspend fun calendarOfExistsDateIncome(date: String): CalendarEntity? =
        calendarDao.calendarOfExistsDateIncome(date)


    override suspend fun getRegisterThisApp(): Boolean = mySharedPref.isRegister

    override suspend fun setRegisterThisApp() {
        mySharedPref.isRegister = true
    }

    override suspend fun getCurrentCurrency(): CurrenciesEntity =
        currenciesDao.getCurrencyById(mySharedPref.currencyId)

    override suspend fun setCurrentCurrency(currenciesEntity: CurrenciesEntity) {
        mySharedPref.currencyId = currenciesEntity.id
    }

    override suspend fun updateCurrencies(currenciesEntity: CurrenciesEntity) {
        currenciesDao.update(currenciesEntity)
    }

    override fun getAllCurrencies(): Flow<List<CurrenciesEntity>> = currenciesDao.getAllCurrencies()

    override suspend fun updateCurrencies(currenciesId: Int, currenciesDollarPrice: Double) {
        currenciesDao.updateCurrencies(currenciesId, currenciesDollarPrice)
    }

    override fun getAllExpansesCategories(): Flow<List<ExpansesCategoryEntity>> =
        expansesCategoryDao.getAllExpansesCategory()

    override suspend fun getExpansesCategoryById(expanseId: Int): ExpansesCategoryEntity =
        expansesCategoryDao.getExpansesCategoryById(expanseId)

    override suspend fun insertExpansesCategory(entity: ExpansesCategoryEntity) {
        expansesCategoryDao.insert(entity)
    }

    override suspend fun updateExpansesCategory(entity: ExpansesCategoryEntity) {
        expansesCategoryDao.update(entity)
    }

    override suspend fun deleteExpansesCategory(entity: ExpansesCategoryEntity) {
        expansesCategoryDao.delete(entity)
    }

    override fun getAllIncomeCategories(): Flow<List<IncomeCategoryEntity>> =
        incomeCategoryDao.getAllIncomeCategory()

    override suspend fun getIncomeCategoryById(incomeId: Int): IncomeCategoryEntity =
        incomeCategoryDao.getExpansesCategoryById(incomeId)

    override suspend fun insertIncomeCategory(entity: IncomeCategoryEntity) {
        incomeCategoryDao.insert(entity)
    }

    override suspend fun updateIncomeCategory(entity: IncomeCategoryEntity) {
        incomeCategoryDao.update(entity)
    }

    override suspend fun deleteIncomeCategory(entity: IncomeCategoryEntity) {
        incomeCategoryDao.delete(entity)
    }

    override suspend fun insertExpansesEntity(expansesEntity: ExpansesEntity) =
        expansesDao.insert(expansesEntity)


    override suspend fun updateExpansesEntity(expansesEntity: ExpansesEntity) =
        expansesDao.update(expansesEntity)


    override suspend fun deleteExpansesEntity(expansesEntity: ExpansesEntity) {
        expansesDao.delete(expansesEntity)
    }

    override fun getAllExpansesByDate(start: Long, end: Long): Flow<List<ExpansesEntity>> =
        expansesDao.getAllExpansesByDate(start, end)

    override suspend fun getExpansesSumByDate(start: Long, end: Long): Double =
        expansesDao.getExpansesSumByDate(start, end)

    override fun getAllExpansesByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<ExpansesEntity>> =
        expansesDao.getAllExpansesByCategoryDate(categoryId, start, end)

    override suspend fun getExpansesSumByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Double =
        expansesDao.getExpansesSumByCategoryDate(categoryId, start, end)

    override suspend fun insertIncomeEntity(entity: IncomeEntity) =
        incomeDao.insert(entity)


    override suspend fun updateIncomeEntity(entity: IncomeEntity) =
        incomeDao.update(entity)

    override suspend fun deleteIncomeEntity(entity: IncomeEntity) {
        incomeDao.delete(entity)
    }

    override fun getAllIncomeByDate(start: Long, end: Long): Flow<List<IncomeEntity>> =
        incomeDao.getAllIncomeByDate(start, end)

    override suspend fun getIncomesSumByDate(start: Long, end: Long): Double =
        incomeDao.getIncomeSumByDate(start, end)

    override fun getAllIncomeByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Flow<List<IncomeEntity>> =
        incomeDao.getAllIncomeByCategoryDate(categoryId, start, end)

    override suspend fun getIncomesSumByCategoryDate(
        categoryId: Int,
        start: Long,
        end: Long
    ): Double =
        incomeDao.getExpansesSumByCategoryDate(categoryId, start, end)

    override suspend fun insertImagesEntity(imagesEntity: ImagesEntity) {
        imagesDao.insert(imagesEntity)
    }

    override suspend fun updateImagesEntity(imagesEntity: ImagesEntity) {
        imagesDao.update(imagesEntity)
    }

    override suspend fun deleteImagesEntity(imagesEntity: ImagesEntity) {
        imagesDao.delete(imagesEntity)
    }

    override suspend fun getAllExpansesImages(expansesId: Int): List<ImagesEntity> =
        imagesDao.getAllExpansesImages(expansesId)

    override suspend fun getAllIncomeImages(incomeId: Int): List<ImagesEntity> =
        imagesDao.getAllIncomeImages(incomeId)

    override suspend fun getCurrentBalance(): Float = mySharedPref.balance

    override suspend fun setCurrentBalance(balance: Float) {
        mySharedPref.balance = balance
    }

    override suspend fun getPin(): String =
        mySharedPref.password

    override suspend fun setPin(pin: String) {
        mySharedPref.password = pin
    }

    override suspend fun getReminder(): String =
        mySharedPref.reminder


    override suspend fun setReminder(reminder: String) {
        mySharedPref.reminder = reminder
    }

    override suspend fun getAllCategories(): List<CategoryEntity> =
        categoriesDao.getAllCategories()

    override suspend fun getIsDarkMode(): Boolean = mySharedPref.appIsDarkMode

    override suspend fun setIsDarkMode() {
        mySharedPref.appIsDarkMode = !mySharedPref.appIsDarkMode
    }

    override suspend fun refreshCurrencies(): List<CBUData> = api.getCurrency().body()!!
}