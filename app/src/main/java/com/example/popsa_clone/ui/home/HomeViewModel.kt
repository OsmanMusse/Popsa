package com.example.popsa_clone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.popsa_clone.domain.HomeRepository
import com.example.popsa_clone.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: HomeRepository
) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState(emptyList()))
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            getProductsListings()
        }
    }

    suspend fun getProductsListings(){
        val products = repo.getProducts()
        _uiState.value = _uiState.value.copy(products = products)
    }


    data class HomeUiState(
        val products: List<Product>
    )
}