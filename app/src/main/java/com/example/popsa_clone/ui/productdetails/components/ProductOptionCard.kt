package com.example.popsa_clone.ui.productdetails.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.popsa_clone.ui.home.components.FromPriceText
import com.example.popsa_clone.ui.home.components.PriceTextSize

@Composable
fun ProductOptionCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(340.dp)
            .padding(top = 5.dp, start = 20.dp, end = 20.dp)
            .border(
                width = 1.8.dp,
                color = Color(0xFFE4E4E4),
                shape = RoundedCornerShape(13.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .padding((20.dp))
        ) {
            MostPopularBadge()
            ProductOptionTitle(title = "Landscape Wall Calendar")
            Spacer(Modifier.height(14.dp))
            FromPriceText(
                originalPrice = 24.0,
                fromPrice = 19.20,
                priceTextSize = PriceTextSize.FEATURED,
                emphasized = true
            )
        }
    }
}

@Composable
fun MostPopularBadge() {
    Text(
        text = "Most Popular",
        color = Color(0xFF05ADC4),
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp,
        lineHeight = 14.5.sp,
        modifier = Modifier.offset(y = 0.dp)
    )
}

@Composable
fun ProductOptionTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.5.sp
    )
}

@Preview()
@Composable
fun ProductOptionCardPreview() {
    ProductOptionCard()
}