package com.example.popsa_clone.ui.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.popsa_clone.ui.utils.formatPrice


enum class PriceTextSize(
    val originalPriceSize: TextUnit,
    val fromPriceSize: TextUnit
) {
    FEATURED(
        originalPriceSize = 17.sp,
        fromPriceSize = 17.sp
    ),
    GRID(
        originalPriceSize = 12.sp,
        fromPriceSize = 14.sp
    )
}

@Composable
fun FromPriceText(
    originalPrice: Double,
    fromPrice: Double,
    priceTextSize: PriceTextSize,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "From",
            fontWeight = FontWeight.Medium,
            fontSize = 14.5.sp,
            lineHeight = 14.5.sp,
            color = Color.Gray,
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = formatPrice(price = originalPrice),
                fontSize = priceTextSize.originalPriceSize,
                fontWeight = FontWeight.ExtraBold,
                textDecoration = TextDecoration.LineThrough,
                color = Color.Gray,
            )

            Text(
                text = formatPrice(price = fromPrice),
                fontSize = priceTextSize.fromPriceSize,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}
