package com.sony.productbrowser.domain.usecase

import com.sony.productbrowser.domain.model.Product
import com.sony.productbrowser.domain.repository.ProductRepository

class GetProductDetailUseCase(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(productId: Int) =
         repository.getProduct(productId)

}