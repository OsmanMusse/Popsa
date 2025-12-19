package com.example.popsa_clone.domain.model
enum class ProductType {
    FEATURED,
    GRID_ITEM;

    companion object {
        fun fromApi(value: String): ProductType =
            entries.firstOrNull() {
                it.name.equals(other = value, ignoreCase = true)
            } ?: GRID_ITEM
    }
}

