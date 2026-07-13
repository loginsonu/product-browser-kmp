package com.sony.productbrowser.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {

    @Serializable
    data object ProductList : Screen

    @Serializable
    data class ProductDetail(
        val productId: Int
    ) : Screen
    @Serializable
    data object Search : Screen
}
