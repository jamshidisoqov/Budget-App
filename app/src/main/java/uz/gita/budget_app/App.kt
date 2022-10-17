package uz.gita.budget_app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Created by Jamshid Isoqov an 10/13/2022
@HiltAndroidApp
class App : Application() {

    companion object {
        var instance: App? = null
        fun getInstanceApp() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}


