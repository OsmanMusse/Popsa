package com.example.popsa_clone.ui.tutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.popsa_clone.R

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