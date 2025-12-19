package com.example.popsa_clone.domain

import com.example.popsa_clone.domain.model.Product

interface HomeRepository {
    suspend fun getProducts(): List<Product>
}