package com.example.popsa_clone.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.popsa_clone.domain.model.Product

@Composable
fun FeaturedProductCard(product: Product) {
    val photoBooksGradient = listOf(
        Color(0xFFEFF6FF),
        Color(0xFFEAE9F8),
        Color(0xFFF4EAF4)
    )
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
                shape = RoundedCornerShape(25.dp)
            )
            .padding(vertical = 15.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {
            Text(
                text = product.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            FromPriceText(
                originalPrice = product.originalPrice,
                fromPrice = product.fromPrice,
                priceTextSize = PriceTextSize.FEATURED
            )

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