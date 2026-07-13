package com.sony.productbrowser.domain.repository

import com.sony.productbrowser.core.result.AppResult
import com.sony.productbrowser.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): AppResult<List<Product>>

    suspend fun getProduct(productId: Int): AppResult<Product>

    suspend fun searchProducts(query: String): AppResult<List<Product>>
}