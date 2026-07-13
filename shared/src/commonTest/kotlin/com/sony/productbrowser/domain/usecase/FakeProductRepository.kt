package com.sony.productbrowser.domain.usecase

import com.sony.productbrowser.core.result.AppResult
import com.sony.productbrowser.domain.model.Product
import com.sony.productbrowser.domain.repository.ProductRepository

class FakeProductRepository : ProductRepository {

    var result: AppResult<List<Product>> = AppResult.Success(emptyList())

    override suspend fun getProducts(): AppResult<List<Product>> = result

    override suspend fun getProduct(productId: Int): AppResult<Product> {
        throw NotImplementedError()
    }

    override suspend fun searchProducts(query: String): AppResult<List<Product>> {
        throw NotImplementedError()
    }
}