package com.example.popsa_clone.data.remote.dto

data class CatalogResponseDto(
    val currency: String,
    val products: List<ProductDto>
)