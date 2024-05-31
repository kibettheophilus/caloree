package com.theophiluskibet.caloree

import android.app.Application
import com.theophiluskibet.caloree.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CaloreeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@CaloreeApplication)
            modules(appModule)
        }
    }
}