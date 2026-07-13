package com.sony.productbrowser.presentation.productdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ProductDetailRoute(
    viewModel: ProductDetailViewModel,
    onBackClick: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    ProductDetailScreen(
        uiState = uiState,
        onRetry = viewModel::getProduct,
        onBackClick = onBackClick
    )

}