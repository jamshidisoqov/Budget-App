package uz.gita.budget_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.budget_app.domain.*
import uz.gita.budget_app.domain.impl.*

// Created by Jamshid Isoqov an 10/14/2022
@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindCalendarUseCase(impl: CalendarUseCaseImpl): CalendarUseCase

    @Binds
    fun bindCategoriesUseCase(impl: CategoryUseCaseImpl): CategoryUseCase

    @Binds
    fun bindCurrenciesUseCase(impl: CurrenciesUseCaseImpl): CurrenciesUseCase

    @Binds
    fun bindsExpansesUseCase(impl: ExpansesUseCaseImpl): ExpansesUseCase

    @Binds
    fun bindImagesUseCase(impl: ImagesUseCaseImpl): ImagesUseCase

    @Binds
    fun bindIncomeUseCase(impl: IncomeUseCaseImpl): IncomeUseCase

    @Binds
    fun bindSettingsUseCase(impl: SettingsUseCaseImpl): SettingsUseCase

    @Binds
    fun bindSplashUseCase(impl: SplashUseCaseImpl): SplashUseCase


}