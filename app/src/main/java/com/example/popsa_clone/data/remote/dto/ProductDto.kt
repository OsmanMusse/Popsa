package com.example.popsa_clone.data.remote.dto

data class ProductDto(
    val id: String,
    val name: String,
    val type: String,
    val imageUrl: String,
    val fromPrice: Double,
    val originalPrice: Double
)