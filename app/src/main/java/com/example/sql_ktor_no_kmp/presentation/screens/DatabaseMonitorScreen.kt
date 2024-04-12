package com.example.sql_ktor_no_kmp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sql_ktor_no_kmp.Database
import com.example.sql_ktor_no_kmp.presentation.ui.theme.modifierMainScreen

@Composable
fun DatabaseMonitorScreen(queries: Database){
    Column(modifier = modifierMainScreen) {
        Text(text = "DatabaseMonitorScreen")
    }
}