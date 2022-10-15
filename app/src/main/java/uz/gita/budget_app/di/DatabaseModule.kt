package uz.gita.budget_app.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.budget_app.data.prefs.MySharedPref
import uz.gita.budget_app.data.room.AppDatabase
import uz.gita.budget_app.data.room.dao.*
import javax.inject.Singleton

// Created by Jamshid Isoqov an 10/14/2022
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(ctx, AppDatabase::class.java, "expanses_income.db")
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

}