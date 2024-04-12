package com.example.sql_ktor_no_kmp.di

import com.example.sql_ktor_no_kmp.data.database.DatabaseDriverFactory
import com.example.sql_ktor_no_kmp.presentation.viewmodel.DatabaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<DatabaseDriverFactory> { DatabaseDriverFactory(get()) }
    viewModel { DatabaseViewModel(get()) }
}