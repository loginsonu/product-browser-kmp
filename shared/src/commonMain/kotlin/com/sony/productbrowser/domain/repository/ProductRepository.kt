package com.sony.productbrowser.domain.repository

import com.sony.productbrowser.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>

    suspend fun getProduct(productId: Int): Product

    suspend fun searchProducts(query: String): List<Product>
}