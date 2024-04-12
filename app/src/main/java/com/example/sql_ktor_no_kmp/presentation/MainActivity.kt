package com.example.sql_ktor_no_kmp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sql_ktor_no_kmp.Database
import com.example.sql_ktor_no_kmp.data.DatabaseDriverFactory
import com.example.sql_ktor_no_kmp.data.DatabaseDriverFactory.Companion.createDatabase
import com.example.sql_ktor_no_kmp.presentation.navigation.BottomBar
import com.example.sql_ktor_no_kmp.presentation.navigation.BottomBarNavGraph
import com.example.sql_ktor_no_kmp.presentation.navigation.BottomBarScreen
import com.example.sql_ktor_no_kmp.presentation.ui.theme.Sql_ktor_example_no_kmpTheme
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {
    private val databaseDriverFactory: DatabaseDriverFactory by inject()
    private val queries = createDatabase(databaseDriverFactory)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val items = queries.itemExampleQueries.selectAll().executeAsList()
        Log.d(LOG_DATABASE, "items = $items")

        setContent {
            Sql_ktor_example_no_kmpTheme {
                MainScreen(queries = queries)
            }
        }
    }
    companion object {
        const val LOG_DATABASE = "LOG_DATABASE"
    }
}

@Composable
fun MainScreen(queries: Database) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        it
        BottomBarNavGraph(navHostController = navController, queries = queries)
    }
}

