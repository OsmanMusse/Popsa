package com.example.popsa_clone.domain.model

data class Product(
    val id: String,
    val name: String,
    val type: ProductType,
    val imageUrl: String,
    val fromPrice: Double,
    val originalPrice: Double
)