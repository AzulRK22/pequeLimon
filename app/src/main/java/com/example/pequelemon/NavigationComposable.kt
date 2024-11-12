package com.example.pequelemon

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Onboarding.route) {
        composable(Onboarding.route) { OnboardingScreen(navController = navController) }
        composable(Home2.route) { HomeScreen2(navController = navController) }
        composable(Profile.route) { ProfileScreen(navController = navController) }

        // Agregar el destino DishDetails con un argumento para el ID del plato
        composable(
            route = "${DishDetails.route}/{${DishDetails.argDishId}}",
            arguments = listOf(navArgument(DishDetails.argDishId) { type = NavType.IntType })
        ) { backStackEntry ->
            val dishId = backStackEntry.arguments?.getInt(DishDetails.argDishId)
            if (dishId != null) {
                DishDetails(navController = navController, id = dishId)
            }
        }
    }
}
