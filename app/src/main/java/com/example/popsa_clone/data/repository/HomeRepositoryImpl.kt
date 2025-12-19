package com.example.popsa_clone.data.repository

import com.example.popsa_clone.data.mapper.toProduct
import com.example.popsa_clone.data.remote.PopsaApi
import com.example.popsa_clone.domain.HomeRepository
import com.example.popsa_clone.domain.model.Product
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(
    private val popsaApi: PopsaApi
) : HomeRepository {
    override suspend fun getProducts(): List<Product> {
        return popsaApi.getCatalog()
            .first()
            .products
            .map { it.toProduct() }
    }

}