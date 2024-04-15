package com.example.sql_ktor_no_kmp.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserActivity(
    val activity: String = "no info",
)
