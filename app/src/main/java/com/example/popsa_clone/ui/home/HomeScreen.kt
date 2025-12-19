package com.example.popsa_clone.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.popsa_clone.domain.model.ProductType
import com.example.popsa_clone.ui.home.components.FeaturedProductCard
import com.example.popsa_clone.ui.home.components.GridProductCard
import com.example.popsa_clone.ui.home.components.HomeSubTitle
import com.example.popsa_clone.ui.home.components.HomeTopAppBar


@Composable
fun HomeRoute(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(state)
}

@Composable
fun HomeScreen(state: HomeViewModel.HomeUiState) {
    Scaffold(
        topBar = { HomeTopAppBar() },
        containerColor = Color.White
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            columns = GridCells.Fixed(2)
        ) {
            item(span = { GridItemSpan(2) }) {
                HomeSubTitle()
            }

            items(
                items = state.products,
                span = { product ->
                    when (product.type) {
                        ProductType.FEATURED -> GridItemSpan(2)
                        ProductType.GRID_ITEM -> GridItemSpan(1)
                    }
                }) { product ->
                when (product.type) {
                    ProductType.FEATURED -> FeaturedProductCard(product)
                    ProductType.GRID_ITEM -> GridProductCard(product)
                }

            }
        }
    }
}
