package com.example.sql_ktor_no_kmp.domain

sealed class State(val message:String) {
    data class Init(val msg: String =""):State(msg)
    data class Loading(val msg: String = "Loading data"):State(msg)
    data class Success(val msg: String):State(msg)
    data class Error(val msg: String):State(msg)
}