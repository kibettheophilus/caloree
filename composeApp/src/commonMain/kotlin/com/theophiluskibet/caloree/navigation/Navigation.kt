package com.theophiluskibet.caloree.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theophiluskibet.calorees.calorees.screens.CaloreesScreen
import com.theophiluskibet.calorees.details.screens.DetailScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "calorees",
    ) {
        composable("calorees") {
            CaloreesScreen(onNavigateToDetails = { food ->
                navController.navigate("details/$food")
            }
            )
        }
        composable("details/{food}") {
            DetailScreen(
                name = it.arguments?.getString("food").toString(),
                onNavigateToBack = { navController.popBackStack() }
            )
        }
    }
}
