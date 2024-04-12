package com.example.sql_ktor_no_kmp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.sql_ktor_no_kmp.presentation.ui.theme.modifierMainScreen

@Composable
fun AboutAppScreen(){
    Column(
        modifier = modifierMainScreen.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "About application")
    }
}