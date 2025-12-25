package com.example.popsa_clone

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.popsa_clone.ui.home.homeGraph
import com.example.popsa_clone.ui.tutorial.TutorialGraph
import com.example.popsa_clone.ui.tutorial.tutorialGraph

@Composable
fun PopsaNavHost() {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier,
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
        homeGraph(navController)
    }
}