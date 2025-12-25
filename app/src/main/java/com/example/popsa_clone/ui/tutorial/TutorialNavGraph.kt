package com.example.popsa_clone.ui.tutorial

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.popsa_clone.ui.home.HomeGraph
import kotlinx.serialization.Serializable

@Serializable
object TutorialGraph

@Serializable
object GetStarted

@Serializable
object SignIn


fun NavGraphBuilder.tutorialGraph(
    navController: NavHostController
) {
    navigation<TutorialGraph>(startDestination = GetStarted) {
        composable<GetStarted> {
            GetStartedScreen(
                onGetStarted = { navController.navigate(SignIn) }
            )
        }
        composable<SignIn> {
            SignInScreen(
                onFinishTutorial = {
                    navController.navigate(HomeGraph) {
                        popUpTo(TutorialGraph)
                    }
                }
            )
        }
    }
}
