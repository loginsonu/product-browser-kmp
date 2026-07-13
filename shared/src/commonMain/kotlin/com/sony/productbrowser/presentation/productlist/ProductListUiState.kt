package com.sony.productbrowser.presentation.productlist

import com.sony.productbrowser.domain.model.Product

data class ProductListUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)