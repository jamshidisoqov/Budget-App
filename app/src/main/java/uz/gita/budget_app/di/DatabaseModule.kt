package uz.gita.budget_app.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.budget_app.data.api.CBUApi
import uz.gita.budget_app.data.models.CurrencyEnum
import uz.gita.budget_app.data.prefs.MySharedPref
import uz.gita.budget_app.data.room.AppDatabase
import uz.gita.budget_app.data.room.dao.*
import uz.gita.budget_app.data.room.entity.CurrenciesEntity
import javax.inject.Singleton

// Created by Jamshid Isoqov an 10/14/2022
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(ctx, AppDatabase::class.java, "expanses_income.db")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val currenciesDao = provideCurrenciesDao(provideDatabase(ctx))
                    CoroutineScope(Dispatchers.IO).launch {
                        val currenciesList = listOf(
                            11131.45,
                            12.41,
                            75.36,
                            12513.98,
                            6551.77,
                            10830.90,
                            37.48,
                            4.61,
                            1.0
                        )

                        for (i in 1..9) {
                            currenciesDao.insert(
                                CurrenciesEntity(
                                    0,
                                    currenciesList[i - 1],
                                    CurrencyEnum.values()[i - 1].name,
                                    0
                                )
                            )
                        }
                    }
                }
            })
            .build()

    @[Provides Singleton]
    fun provideCalendarDao(appDatabase: AppDatabase): CalendarDao =
        appDatabase.calendarDao()

    @[Provides Singleton]
    fun provideCategoriesDao(appDatabase: AppDatabase): CategoriesDao =
        appDatabase.categoriesDao()

    @[Provides Singleton]
    fun provideCurrenciesDao(appDatabase: AppDatabase): CurrenciesDao =
        appDatabase.currenciesDao()

    @[Provides Singleton]
    fun provideExpansesCategoryDao(appDatabase: AppDatabase): ExpansesCategoryDao =
        appDatabase.expansesCategoryDao()

    @[Provides Singleton]
    fun provideExpansesDao(appDatabase: AppDatabase): ExpansesDao =
        appDatabase.expansesDao()

    @[Provides Singleton]
    fun provideImagesDao(appDatabase: AppDatabase): ImagesDao =
        appDatabase.imagesDao()

    @[Provides Singleton]
    fun provideIncomeCategoryDao(appDatabase: AppDatabase): IncomeCategoryDao =
        appDatabase.incomeCategoryDao()

    @[Provides Singleton]
    fun provideIncomeDao(appDatabase: AppDatabase): IncomeDao =
        appDatabase.incomeDao()

    @[Provides Singleton]
    fun provideSharedPref(@ApplicationContext ctx: Context): SharedPreferences =
        ctx.getSharedPreferences("app_date", Context.MODE_PRIVATE)

    @[Provides Singleton]
    fun provideMySharedPref(
        @ApplicationContext ctx: Context,
        sharedPreferences: SharedPreferences
    ): MySharedPref = MySharedPref(ctx, sharedPreferences)


    @[Provides Singleton]
    fun provideRetrofit(): Retrofit = Retrofit
        .Builder()
        .baseUrl("https://cbu.uz/uz/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Provides Singleton]
    fun provideAuthApi(retrofit: Retrofit): CBUApi = retrofit.create(CBUApi::class.java)

}