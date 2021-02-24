package me.inassar.koindependencyinjection

import android.app.Application
import me.inassar.koindependencyinjection.di.stateModule
import me.inassar.koindependencyinjection.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(listOf(stateModule, viewModelModule))
        }
    }
}