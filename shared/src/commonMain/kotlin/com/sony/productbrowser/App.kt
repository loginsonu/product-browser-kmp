package com.sony.productbrowser


import androidx.compose.runtime.*
import com.sony.productbrowser.core.di.AppContainer
import com.sony.productbrowser.presentation.navigation.AppNavigation
import com.sony.productbrowser.presentation.theme.AppTheme

@Composable
fun App() {

    AppTheme {

        val productListViewModel = remember {
            AppContainer.provideProductListViewModel()
        }

        AppNavigation(
            appContainer = AppContainer,
            productListViewModel = productListViewModel
        )


    }

}