package uz.gita.budget_app.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.budget_app.data.room.dao.*
import uz.gita.budget_app.data.room.entity.*

// Created by Jamshid Isoqov an 10/13/2022
@Database(
    entities = [
        CalendarEntity::class,
        CategoryEntity::class,
        CurrenciesEntity::class,
        ExpansesCategoryEntity::class,
        ExpansesEntity::class,
        ImagesEntity::class,
        IncomeEntity::class,
        IncomeCategoryEntity::class,
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun calendarDao(): CalendarDao

    abstract fun categoriesDao(): CategoriesDao

    abstract fun currenciesDao(): CurrenciesDao

    abstract fun expansesDao(): ExpansesDao

    abstract fun imagesDao(): ImagesDao

    abstract fun expansesCategoryDao(): ExpansesCategoryDao

    abstract fun incomeCategoryDao(): IncomeCategoryDao

    abstract fun incomeDao(): IncomeDao

}