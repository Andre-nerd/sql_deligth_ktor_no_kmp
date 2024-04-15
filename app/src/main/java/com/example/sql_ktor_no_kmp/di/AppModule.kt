package com.example.sql_ktor_no_kmp.di

import com.example.sql_ktor_no_kmp.data.api.ApiService
import com.example.sql_ktor_no_kmp.data.api.ApiServiceProvider
import com.example.sql_ktor_no_kmp.data.database.DatabaseDriverFactory
import com.example.sql_ktor_no_kmp.presentation.viewmodel.ApiViewModel
import com.example.sql_ktor_no_kmp.presentation.viewmodel.DatabaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<DatabaseDriverFactory> { DatabaseDriverFactory(get()) }
    single<ApiServiceProvider> { ApiServiceProvider() }
    single<ApiService> { ApiService(get()) }
    viewModel { DatabaseViewModel(get()) }
    viewModel { ApiViewModel(get()) }
}