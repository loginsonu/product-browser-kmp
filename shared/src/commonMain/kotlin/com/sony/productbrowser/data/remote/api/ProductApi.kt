package com.sony.productbrowser.data.remote.api

import com.sony.productbrowser.data.remote.dto.ProductDto
import com.sony.productbrowser.data.remote.dto.ProductsResponseDto

interface ProductApi {

    suspend fun getProducts(): ProductsResponseDto

    suspend fun getProduct(productId: Int): ProductDto

    suspend fun searchProducts(query: String): ProductsResponseDto
}