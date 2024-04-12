package com.example.sql_ktor_no_kmp

import android.app.Application
import com.example.sql_ktor_no_kmp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(appModule)
        }
    }
}