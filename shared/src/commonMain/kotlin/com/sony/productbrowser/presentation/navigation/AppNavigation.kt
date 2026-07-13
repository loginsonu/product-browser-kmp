package com.sony.productbrowser.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sony.productbrowser.core.di.AppContainer
import com.sony.productbrowser.presentation.productdetail.ProductDetailRoute
import com.sony.productbrowser.presentation.productdetail.ProductDetailScreen
import com.sony.productbrowser.presentation.productlist.ProductListRoute
import com.sony.productbrowser.presentation.productlist.ProductListViewModel

@Composable
fun AppNavigation(
    appContainer: AppContainer,
    productListViewModel: ProductListViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.ProductList
    ) {

        composable<Screen.ProductList> {



            ProductListRoute(
                viewModel = productListViewModel,
                onRetry = productListViewModel::fetchProducts,
                onProductClick = { productId ->

                    navController.navigate(
                        Screen.ProductDetail(productId)
                    )

                }
            )

        }

        composable<Screen.ProductDetail> { backStackEntry ->

            val route =
                backStackEntry.toRoute<Screen.ProductDetail>()

            val viewModel = remember {

                appContainer.provideProductDetailViewModel(route.productId)

            }

            ProductDetailRoute(
                viewModel = viewModel,
                onBackClick = {
                    navController.navigateUp()
                }
            )

        }

    }

}