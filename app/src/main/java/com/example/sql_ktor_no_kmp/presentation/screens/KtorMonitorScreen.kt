package com.example.sql_ktor_no_kmp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.sql_ktor_no_kmp.presentation.ui.theme.modifierMainScreen

@Composable
fun KtorMonitorScreen(){
    Column(modifier = modifierMainScreen) {
        Text(text = "KtorMonitorScreen")
    }
}