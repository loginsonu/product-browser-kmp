package com.sony.productbrowser.data.remote.api

import com.sony.productbrowser.core.network.HttpClientFactory
import com.sony.productbrowser.core.network.NetworkConstants
import com.sony.productbrowser.data.remote.dto.ProductDto
import com.sony.productbrowser.data.remote.dto.ProductsResponseDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ProductApiImpl(
    httpClientFactory: HttpClientFactory
) : ProductApi {

    private val client = httpClientFactory.create()

    override suspend fun getProducts(): ProductsResponseDto {
        return client.get(NetworkConstants.PRODUCTS).body()
    }

    override suspend fun getProduct(productId: Int): ProductDto {
        return client.get("${NetworkConstants.PRODUCTS}/$productId").body()
    }

    override suspend fun searchProducts(query: String): ProductsResponseDto {
        return client.get(NetworkConstants.SEARCH) {
            parameter("q", query)
        }.body()
    }
}