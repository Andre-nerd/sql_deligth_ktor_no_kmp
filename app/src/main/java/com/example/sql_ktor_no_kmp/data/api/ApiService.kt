package com.example.sql_ktor_no_kmp.data.api

import com.example.sql_ktor_no_kmp.domain.UserActivity
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val apiServiceProvider: ApiServiceProvider) {
    suspend fun getUserActivity(): UserActivity{
        return apiServiceProvider.httpClient.get("https://www.boredapi.com/api/activity/").body()
    }
}