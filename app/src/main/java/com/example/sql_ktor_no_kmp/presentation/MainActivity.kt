package com.example.sql_ktor_no_kmp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.sql_ktor_no_kmp.presentation.navigation.BottomBar
import com.example.sql_ktor_no_kmp.presentation.navigation.BottomBarNavGraph
import com.example.sql_ktor_no_kmp.presentation.ui.theme.Sql_ktor_example_no_kmpTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sql_ktor_example_no_kmpTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        it
        BottomBarNavGraph(navHostController = navController)
    }
}

