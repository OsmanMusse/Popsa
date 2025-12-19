package com.example.popsa_clone.data.remote

import com.example.popsa_clone.data.remote.dto.CatalogResponseDto
import retrofit2.http.GET


interface PopsaApi {
    @GET("catalog")
    suspend fun getCatalog(): List<CatalogResponseDto>
    companion object {
        const val BASE_URL = "https://69407ce2993d68afba6c3ec3.mockapi.io/api/v1/"
    }
}
