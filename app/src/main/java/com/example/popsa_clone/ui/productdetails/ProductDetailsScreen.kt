package com.example.popsa_clone.ui.productdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.popsa_clone.ui.productdetails.components.ProductDetailsTopAppBar
import com.example.popsa_clone.ui.productdetails.components.ProductOptionCard
import com.example.popsa_clone.ui.productdetails.components.ProductSubTitle

@Composable
fun ProductDetailsScreen(
    topAppBarTitle: String,
    onNavIconClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            ProductDetailsTopAppBar(
                title = topAppBarTitle,
                onNavIconClicked = onNavIconClicked
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ProductSubTitle()
            ProductOptionCard(imageUrl = "https://popsa.com/_next/image/?url=https%3A%2F%2Fcdn.popsa.io%2Fnew-product-photography%2Foffering%2FCALENDAR_LANDSCAPE_MEDIUM.png&w=1920&q=75")
            Spacer(Modifier.height(15.dp))
            ProductOptionCard(imageUrl = "https://popsa.com/_next/image/?url=https%3A%2F%2Fcdn.popsa.io%2Fnew-product-photography%2Foffering%2FCALENDAR_PORTRAIT.png&w=1920&q=75")
        }
    }
}
