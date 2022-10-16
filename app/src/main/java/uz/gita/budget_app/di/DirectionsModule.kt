package uz.gita.budget_app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.budget_app.directions.IntroScreenDirections
import uz.gita.budget_app.directions.impl.IntroScreenDirectionsImpl

@Module
@InstallIn(SingletonComponent::class)
interface DirectionsModule {
    @Binds
    fun bindsIntroDirection(impl: IntroScreenDirectionsImpl): IntroScreenDirections
}