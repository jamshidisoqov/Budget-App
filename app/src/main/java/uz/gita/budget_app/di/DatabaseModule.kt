package uz.gita.budget_app.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.budget_app.data.room.AppDatabase
import uz.gita.budget_app.data.room.dao.CalendarDao
import uz.gita.budget_app.data.room.dao.CategoriesDao
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


}