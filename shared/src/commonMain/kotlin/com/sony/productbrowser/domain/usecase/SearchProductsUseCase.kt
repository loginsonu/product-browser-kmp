package com.sony.productbrowser.domain.usecase

import com.sony.productbrowser.domain.model.Product
import com.sony.productbrowser.domain.repository.ProductRepository

class SearchProductsUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(query: String): List<Product> {
        return repository.searchProducts(query)
    }
}