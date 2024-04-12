package com.example.sql_ktor_no_kmp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CastConnected
import androidx.compose.material.icons.filled.Storage
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val icon: ImageVector,
    val tittle:String
    ){
    data object DataBaseScreen:BottomBarScreen(
        route = "DataBaseScreen",
        icon = Icons.Default.Storage,
        tittle = "Database"
    )
    data object KtorRestScreen:BottomBarScreen(
        route = "KtorRestScreen",
        icon = Icons.Default.CastConnected,
        tittle = "Ktor"
    )
}