package com.sony.productbrowser.presentation.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sony.productbrowser.core.result.AppResult
import com.sony.productbrowser.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductListViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductListUiState())

    val uiState: StateFlow<ProductListUiState> = _uiState.asStateFlow()

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {

            // Show loading
            _uiState.update {
                it.copy(
                    isLoading = true
                )
            }

            when (val result = getProductsUseCase()) {

                is AppResult.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            products = result.data,
                            error = null
                        )
                    }
                }

                is AppResult.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
}