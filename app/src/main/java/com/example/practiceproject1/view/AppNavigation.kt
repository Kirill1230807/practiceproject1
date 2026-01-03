package com.example.practiceproject1.view

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigationevent.compose.rememberNavigationEventState
import com.example.practiceproject1.R
import com.example.practiceproject1.model.Product
import com.example.practiceproject1.viewmodel.ProductViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val viewModel: ProductViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "Main Screen"
    ) {
        composable("Main Screen") {
            MainScreen(viewModel, navController = navController)
        }
        composable("Add") {
            AddItemScreen(viewModel = viewModel, navController = navController)
        }
        composable(
            "details/{productId}",
            arguments = listOf(
                navArgument("productId") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { backStackEntry ->

            val productId = backStackEntry.arguments?.getInt("productId")

            val foundProduct = viewModel.getProductById(productId ?: 0)

            if (foundProduct != null) {
                DetailScreen(product = foundProduct, navController = navController)
            }
        }
    }
}