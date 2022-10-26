package com.example.cleanarch

import android.app.Application
import com.example.cleanarch.di.apiModule
import com.example.cleanarch.di.appModule
import com.example.cleanarch.di.networkModule
import com.example.cleanarch.di.repoModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    repoModule,
                    appModule,
                    apiModule,
                    networkModule
                )
            )
        }
    }
}