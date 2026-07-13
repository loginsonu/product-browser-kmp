package com.sony.productbrowser.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import productbrowser.shared.generated.resources.search_products


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    uiState: SearchUiState,
    onQueryChange: (String) -> Unit,
    onRetry: () -> Unit,
    onBackClick: () -> Unit,
    onProductClick: (Int) -> Unit
) {

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {
                    Text(
                        text = stringResource(Res.string.search_products)
                    )
                },

                navigationIcon = {

                    IconButton(
                        onClick = onBackClick
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null
                        )

                    }

                }

            )

        }

    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                value = uiState.query,

                onValueChange = {onQueryChange(it)},

                singleLine = true,

                leadingIcon = {

                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )

                },

                placeholder = {

                    Text(
                        text = stringResource(
                            Res.string.search_products
                        )
                    )

                }

            )

            HorizontalDivider()

            Box(
                modifier = Modifier.fillMaxSize()
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

                    uiState.query.isNotBlank() &&
                            uiState.products.isEmpty() -> {

                        EmptyView(
                            message = stringResource(
                                Res.string.no_products_found
                            )
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

}

@Preview
@Composable
private fun SearchPreview() {

    AppTheme {

        SearchScreen(
            uiState = SearchUiState(
                query = "phone",
                products = PreviewData.products
            ),
            onQueryChange = {},
            onRetry = {},
            onBackClick = {},
            onProductClick = {}
        )

    }

}