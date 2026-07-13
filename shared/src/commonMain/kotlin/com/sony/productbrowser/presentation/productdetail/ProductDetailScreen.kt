package com.sony.productbrowser.presentation.productdetail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sony.productbrowser.presentation.components.ErrorView
import com.sony.productbrowser.presentation.components.LoadingView
import com.sony.productbrowser.presentation.preview.PreviewData
import com.sony.productbrowser.presentation.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import productbrowser.shared.generated.resources.Res
import productbrowser.shared.generated.resources.product_details


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(
    uiState: ProductDetailUiState,
    onRetry: () -> Unit,
    onBackClick: () -> Unit
) {

    Scaffold(

        topBar = {

            CenterAlignedTopAppBar(

                title = {
                    Text(
                        text = stringResource(Res.string.product_details)
                    )
                },

                navigationIcon = {

                    IconButton(
                        onClick = onBackClick
                    ) {

                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )

                    }

                }

            )

        }

    ) { padding ->

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

            uiState.product != null -> {

                ProductDetailContent(
                    modifier = androidx.compose.ui.Modifier,
                    contentPadding = padding,
                    product = uiState.product
                )

            }

        }

    }

}

@Preview
@Composable
private fun ProductDetailScreenPreview() {

    AppTheme {

        ProductDetailScreen(
            uiState = ProductDetailUiState(
                product = PreviewData.products.first()
            ),
            onRetry = {},
            onBackClick = {}
        )

    }

}