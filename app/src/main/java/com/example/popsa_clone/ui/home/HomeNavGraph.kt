package com.example.popsa_clone.ui.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.example.popsa_clone.ui.productdetails.ProductDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeGraph

@Serializable
object Home

@Serializable
data class ProductDetails(val title: String)


fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation<HomeGraph>(startDestination = Home) {
        composable<Home> {
            HomeRoute(
                onSelectProduct = { title ->
                    navController.navigate(ProductDetails(title))
                }
            )
        }

        composable<ProductDetails> { backStackEntry ->
            val product: ProductDetails = backStackEntry.toRoute()
            ProductDetailsScreen(
                topAppBarTitle = product.title,
                onNavIconClicked = { navController.popBackStack() }
            )
        }
    }
}