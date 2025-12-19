package com.example.popsa_clone.data.mapper

import com.example.popsa_clone.data.remote.dto.ProductDto
import com.example.popsa_clone.domain.model.Product
import com.example.popsa_clone.domain.model.ProductType

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        name = name,
        type = ProductType.fromApi(type),
        imageUrl = imageUrl,
        fromPrice = fromPrice,
        originalPrice = originalPrice
    )
}