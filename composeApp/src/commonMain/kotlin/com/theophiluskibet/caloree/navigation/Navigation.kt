package com.theophiluskibet.caloree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theophiluskibet.caloree.home.screens.calorees.HomeScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    NavHost(
        modifier = Modifier,
        navController = rememberNavController(),
        startDestination = "calorees",
    ) {
        composable("calorees") {
            HomeScreen()
        }
    }
}
