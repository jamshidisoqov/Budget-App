package uz.gita.budget_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.budget_app.repository.BudgetRepository
import uz.gita.budget_app.repository.impl.BudgetRepositoryImpl

// Created by Jamshid Isoqov an 10/14/2022
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAppRepository(impl: BudgetRepositoryImpl): BudgetRepository

}