package com.example.popsa_clone.ui.productdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.popsa_clone.ui.productdetails.components.ProductDetailsTopAppBar
import com.example.popsa_clone.ui.productdetails.components.ProductOptionCard
import com.example.popsa_clone.ui.productdetails.components.ProductSubTitle

@Composable
fun ProductDetailsScreen(
    topAppBarTitle: String,
    onNavIconClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
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
            ProductOptionCard()
        }
    }
}
