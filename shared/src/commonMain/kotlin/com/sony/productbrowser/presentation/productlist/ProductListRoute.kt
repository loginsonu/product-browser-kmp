package com.sony.productbrowser.presentation.productlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ProductListRoute(
    viewModel: ProductListViewModel,
    onProductClick: (Int) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    ProductListScreen(
        uiState = uiState,
        onRetry = viewModel::fetchProducts,
        onProductClick = onProductClick
    )
}