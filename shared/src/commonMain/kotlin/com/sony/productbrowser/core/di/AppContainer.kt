package com.sony.productbrowser.core.di

import com.sony.productbrowser.core.network.HttpClientFactory
import com.sony.productbrowser.data.remote.api.ProductApi
import com.sony.productbrowser.data.remote.api.ProductApiImpl
import com.sony.productbrowser.data.repository.ProductRepositoryImpl
import com.sony.productbrowser.domain.repository.ProductRepository
import com.sony.productbrowser.domain.usecase.GetProductDetailUseCase
import com.sony.productbrowser.domain.usecase.GetProductsUseCase
import com.sony.productbrowser.domain.usecase.SearchProductsUseCase

object AppContainer {

    private val httpClientFactory by lazy {
        HttpClientFactory()
    }

    private val productApi: ProductApi by lazy {
        ProductApiImpl(httpClientFactory)
    }

    private val productRepository: ProductRepository by lazy {
        ProductRepositoryImpl(productApi)
    }

    val getProductsUseCase by lazy {
        GetProductsUseCase(productRepository)
    }

    val getProductDetailUseCase by lazy {
        GetProductDetailUseCase(productRepository)
    }

    val searchProductsUseCase by lazy {
        SearchProductsUseCase(productRepository)
    }
}