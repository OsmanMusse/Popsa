package com.example.popsa_clone.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
    FEATURED(originalPriceSize = 15.5.sp, fromPriceSize = 16.5.sp),
    GRID(originalPriceSize = 12.sp, fromPriceSize = 14.sp),
}

@Composable
fun FromPriceText(
    originalPrice: Double,
    fromPrice: Double,
    priceTextSize: PriceTextSize,
    emphasized: Boolean = false
) {

    val fromText = if (emphasized) "FROM" else "From"
    Column {
        Text(
            text = fromText,
            fontWeight = FontWeight.Medium,
            fontSize = if (emphasized) 12.sp else 13.sp,
            lineHeight = 13.sp,
            color = if (emphasized) Color.Black else Color.Gray,
        )

        if (emphasized) Spacer(Modifier.height(3.dp))

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
