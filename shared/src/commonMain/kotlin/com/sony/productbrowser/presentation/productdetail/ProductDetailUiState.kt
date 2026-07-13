package com.sony.productbrowser.presentation.productdetail

import com.sony.productbrowser.domain.model.Product

data class ProductDetailUiState(

    val isLoading: Boolean = false,

    val product: Product? = null,

    val error: String? = null

)