package com.example.sql_ktor_no_kmp.presentation.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import com.example.sql_ktor_no_kmp.Database
import com.example.sql_ktor_no_kmp.presentation.screens.DatabaseMonitorScreen
import com.example.sql_ktor_no_kmp.presentation.screens.KtorMonitorScreen

@Composable
fun BottomBarNavGraph(
    navHostController: NavHostController,
    queries: Database
){
    NavHost(navController = navHostController, startDestination = BottomBarScreen.DataBaseScreen.route ){
        composable(route = BottomBarScreen.DataBaseScreen.route){
            DatabaseMonitorScreen(queries = queries)
        }
        composable(route = BottomBarScreen.KtorRestScreen.route){
            KtorMonitorScreen()
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    navDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        icon = { Icon(imageVector = screen.icon, contentDescription = screen.tittle) },
        label = { Text(text = screen.tittle) },
        selected = navDestination?.hierarchy?.any { it.route == screen.route } == true,
        onClick = { navController.navigate(screen.route) }
    )
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.DataBaseScreen,
        BottomBarScreen.KtorRestScreen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                navDestination = currentDestination,
                navController = navController
            )
        }
    }
}