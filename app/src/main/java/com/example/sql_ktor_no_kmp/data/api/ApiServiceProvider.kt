package com.example.sql_ktor_no_kmp.data.api

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiServiceProvider {
    private val _httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.i(LOG_API,message)
                }
            }
            level = LogLevel.BODY
        }

    }
    val httpClient:HttpClient
        get() = _httpClient
    companion object{
        const val LOG_API = "LOG_API"
    }
}