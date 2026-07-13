package com.sony.productbrowser.presentation.productlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ProductListRoute(
    viewModel: ProductListViewModel,
    onRetry: () -> Unit,
    onProductClick: (Int) -> Unit,
    onSearchClicked: ()-> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    ProductListScreen(
        uiState = uiState,
        onRetry = onRetry,
        onProductClick = onProductClick,
        onSearchClicked= onSearchClicked
    )

}