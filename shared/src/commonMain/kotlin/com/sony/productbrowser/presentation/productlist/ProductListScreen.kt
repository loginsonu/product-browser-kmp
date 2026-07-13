package com.sony.productbrowser.presentation.productlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sony.productbrowser.presentation.components.EmptyView
import com.sony.productbrowser.presentation.components.ErrorView
import com.sony.productbrowser.presentation.components.LoadingView
import com.sony.productbrowser.presentation.components.ProductItem
import com.sony.productbrowser.presentation.preview.PreviewData
import com.sony.productbrowser.presentation.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import productbrowser.shared.generated.resources.Res
import productbrowser.shared.generated.resources.no_products_found
import productbrowser.shared.generated.resources.products

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    uiState: ProductListUiState,
    onRetry: () -> Unit,
    onProductClick: (Int) -> Unit,
    onSearchClicked:()->Unit = {}
) {

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text(text = stringResource(Res.string.products))
                },
                actions = {
                    IconButton(
                        onClick = onSearchClicked
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }
                }
            )

        }

    ) { innerPadding ->

        Box(
            modifier = Modifier.padding(innerPadding)
        ) {

            when {

                uiState.isLoading -> {

                    LoadingView()

                }

                uiState.error != null -> {

                    ErrorView(
                        message = uiState.error,
                        onRetry = onRetry
                    )

                }

                uiState.products.isEmpty() -> {

                    EmptyView(
                        message = stringResource(Res.string.no_products_found)
                    )

                }

                else -> {

                    LazyVerticalGrid(
                        modifier = Modifier.fillMaxSize(),
                        columns = GridCells.Adaptive(
                            minSize = 160.dp
                        ),
                        contentPadding = PaddingValues(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        items(
                            items = uiState.products,
                            key = { it.id }
                        ) { product ->

                            ProductItem(
                                product = product,
                                onClick = {
                                    onProductClick(product.id)
                                }
                            )

                        }

                    }

                }

            }

        }

    }

}

@Preview
@Composable
private fun ProductListPreview() {

    AppTheme {

        ProductListScreen(
            uiState = ProductListUiState(
                products = PreviewData.products
            ),
            onRetry = {},
            onProductClick = {}
        )

    }

}

@Preview
@Composable
private fun ProductListLoadingPreview() {

    AppTheme {

        ProductListScreen(
            uiState = ProductListUiState(
                isLoading = true
            ),
            onRetry = {},
            onProductClick = {}
        )

    }

}

@Preview
@Composable
private fun ProductListErrorPreview() {

    AppTheme {

        ProductListScreen(
            uiState = ProductListUiState(
                error = "Unable to load products."
            ),
            onRetry = {},
            onProductClick = {}
        )

    }

}

@Preview
@Composable
private fun ProductListEmptyPreview() {

    AppTheme {

        ProductListScreen(
            uiState = ProductListUiState(),
            onRetry = {},
            onProductClick = {}
        )

    }

}