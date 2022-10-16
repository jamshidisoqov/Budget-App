package uz.gita.budget_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.budget_app.directions.IntroScreenDirections
import uz.gita.budget_app.directions.SplashScreenDirections
import uz.gita.budget_app.directions.impl.IntroScreenDirectionsImpl
import uz.gita.budget_app.directions.impl.SplashScreenDirectionImpl

// Created by Jamshid Isoqov an 10/14/2022
@Module
@InstallIn(SingletonComponent::class)
interface DirectionsModule {

    @Binds
    fun bindIntroScreenDirections(impl: IntroScreenDirectionsImpl): IntroScreenDirections

    @Binds
    fun bindsSplashScreen(impl:SplashScreenDirectionImpl):SplashScreenDirections

}