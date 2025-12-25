package com.example.popsa_clone.ui.productdetails.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductSubTitle() {
    Text(
        text = "Personalise these stunning wall calendars with your own photos and events.",
        color = Color.Gray,
        fontSize = 14.5.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding((20.dp))
    )
}