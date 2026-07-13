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
import com.sony.productbrowser.presentation.search.SearchRoute

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

                },
                onSearchClicked = {
                    navController.navigate(Screen.Search)
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

        // Search
        composable<Screen.Search> {

            val viewModel = remember {
                appContainer.provideSearchViewModel()
            }

            SearchRoute(
                viewModel = viewModel,
                onBackClick = {
                    navController.navigateUp()
                },
                onProductClick = { productId ->
                    navController.navigate(
                        Screen.ProductDetail(productId)
                    ){
                        popUpTo(Screen.Search) {
                            inclusive = true
                        }
                    }
                }
            )
        }

    }

}