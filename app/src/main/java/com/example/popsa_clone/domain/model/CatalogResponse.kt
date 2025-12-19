package com.example.popsa_clone.domain.model

import com.example.popsa_clone.data.remote.dto.ProductDto

data class CatalogResponse(
    val currency: String,
    val products: List<ProductDto>
)
