package com.example.popsa_clone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.popsa_clone.ui.theme.PopsaCloneTheme
import kotlinx.serialization.Serializable

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

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { PopsaTopAppBar() },
        containerColor = Color.White
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 30.dp),
            columns = GridCells.Fixed(2)
        ) {
            item(span = { GridItemSpan(2) }) {
                Text(
                    text = "What do you want to create today?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 33.sp,
                    color = Color(0xFF5B5E60)
                )
            }
            item(span = { GridItemSpan(2) }) {
                FeaturedProductCard()
            }
        }
    }
}


@Composable
fun PopsaTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .statusBarsPadding(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.logo_icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.height(23.dp)
        )

        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun FeaturedProductCard() {
    val photoBooksGradient = listOf(
        Color(0xFFEFF6FF),
        Color(0xFFEAE9F8),
        Color(0xFFF4EAF4)
    )
    Column(
        modifier = Modifier.padding(vertical = 15.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = photoBooksGradient,
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    ),
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(vertical = 15.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "Photo Books",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "From",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.5.sp
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    Text(
                        text = "£22",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        textDecoration = TextDecoration.LineThrough
                    )
                    Text(text = "£11", fontWeight = FontWeight.Bold)
                }

                Spacer(Modifier.weight(1F))

                Button(
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                    onClick = {}
                ) {
                    Text(text = "Create")
                }
            }
        }
    }

}


@Composable
fun SignInScreen(
    onFinishTutorial: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            onClick = { onFinishTutorial() }
        ) {
            Text("Go to HomeScreen")
        }
    }
}

@Composable
fun GetStartedScreen(onGetStarted: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFEAE9F6),
                        Color(0xFFDCD0E6),
                        Color(0xFFD9C6E0),
                    )
                )
            )

    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 45.dp, 55.dp)
                .align(Alignment.BottomCenter)
        ) {
            LogoIcon()
            ContentSubtitle()
            GradientButton(onGetStarted = { onGetStarted() })
        }

    }
}

@Composable
fun LogoIcon() {
    Icon(
        modifier = Modifier.padding(bottom = 16.dp),
        imageVector = ImageVector.vectorResource(R.drawable.logo_icon),
        contentDescription = null,
        tint = Color(0xFF8E3D8C)
    )
}

@Composable
fun ContentSubtitle() {
    Text(
        text = "The easiest way to print your memories",
        color = Color(0xFF6F2C8F),
        fontSize = 27.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = "Create something beautifully unique in just 5 minutes",
        color = Color(0xFF9B5C8F),
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    )
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun GradientButton(onGetStarted: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(10.dp),
        onClick = onGetStarted
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF8C4E8A), // left
                            Color(0xFF2E3192)  // right
                        )
                    ),
                    shape = RoundedCornerShape(10.dp),
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Get Started")
        }
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
        composable<Home> { HomeScreen() }
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
