package com.example.sql_ktor_no_kmp.di

import com.example.sql_ktor_no_kmp.data.DatabaseDriverFactory
import org.koin.dsl.module

val appModule = module {
    single<DatabaseDriverFactory> { DatabaseDriverFactory(get()) }
}