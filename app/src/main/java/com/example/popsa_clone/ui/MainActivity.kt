package com.example.popsa_clone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.popsa_clone.ui.home.HomeRoute
import com.example.popsa_clone.ui.tutorial.GetStartedScreen
import com.example.popsa_clone.ui.tutorial.SignInScreen
import com.example.popsa_clone.ui.theme.PopsaCloneTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PopsaCloneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    AppNavHost()
                }
            }
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = TutorialGraph,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(300)
            )
        },
    ) {
        tutorialGraph(navController)
        homeGraph()
    }

}


// Nested Graph

// 1- Tutorial Graph
// 2- Home Graph


@Serializable
object HomeGraph

@Serializable
object Home

// HomeNavigation.kt
fun NavGraphBuilder.homeGraph() {
    navigation<HomeGraph>(startDestination = Home) {
        composable<Home> { HomeRoute() }
    }
}


@Serializable
object TutorialGraph

@Serializable
object GetStarted

@Serializable
object SignIn

// TutorialNavigation.kt
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
