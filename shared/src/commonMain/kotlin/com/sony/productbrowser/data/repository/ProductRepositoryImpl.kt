package com.sony.productbrowser.data.repository


import com.sony.productbrowser.core.result.AppResult
import com.sony.productbrowser.core.result.safeApiCall
import com.sony.productbrowser.data.remote.api.ProductApi
import com.sony.productbrowser.data.remote.mapper.toDomain
import com.sony.productbrowser.domain.model.Product
import com.sony.productbrowser.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productApi: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): AppResult<List<Product>> =
        safeApiCall {
            productApi
                .getProducts()
                .products
                .map { it.toDomain() }
        }


    override suspend fun getProduct(productId: Int): AppResult<Product> =

         safeApiCall {
             productApi
              .getProduct(productId)
              .toDomain()
         }



    override suspend fun searchProducts(query: String): AppResult<List<Product>> =

        safeApiCall {
            productApi
                .searchProducts(query)
                .products
                .map { it.toDomain() }
        }

}