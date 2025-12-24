package com.example.popsa_clone.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.popsa_clone.domain.model.Product

@Composable
fun GridProductCard(
    product: Product,
    onSelectProduct: () -> Unit
) {
    Column(
        modifier = Modifier.clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = { onSelectProduct() }
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    color = Color.Blue,
                    shape = RoundedCornerShape(19.dp)
                )
        ) {
            // Async Image
        }
        GridProductInfo(product)
    }

}

@Composable
fun GridProductInfo(product: Product) {
    Column(
        modifier = Modifier.padding(horizontal = 7.5.dp, vertical = 7.5.dp)
    ) {
        Text(
            text = product.name,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp

        )
        FromPriceText(
            originalPrice = product.originalPrice,
            fromPrice = product.fromPrice,
            priceTextSize = PriceTextSize.GRID
        )
    }
}
