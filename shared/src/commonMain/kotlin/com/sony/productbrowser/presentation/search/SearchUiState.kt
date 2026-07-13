package com.sony.productbrowser.presentation.search

import com.sony.productbrowser.domain.model.Product

data class SearchUiState(

    val query: String = "",

    val products: List<Product> = emptyList(),

    val isLoading: Boolean = false,

    val error: String? = null

)