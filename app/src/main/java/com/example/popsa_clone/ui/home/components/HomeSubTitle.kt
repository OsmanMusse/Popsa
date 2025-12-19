package com.example.popsa_clone.ui.home.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HomeSubTitle() {
    Text(
        text = "What do you want to create today?",
        fontSize = 24.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 33.sp,
        color = Color(0xFF5B5E60)
    )
}