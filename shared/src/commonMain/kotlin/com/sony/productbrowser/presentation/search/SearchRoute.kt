package com.sony.productbrowser.presentation.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun SearchRoute(
    viewModel: SearchViewModel,
    onBackClick: () -> Unit,
    onProductClick: (Int) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    SearchScreen(
        uiState = uiState,
        onQueryChange = viewModel::onQueryChange,
        onRetry = viewModel::searchProducts,
        onBackClick = onBackClick,
        onProductClick = onProductClick
    )

}