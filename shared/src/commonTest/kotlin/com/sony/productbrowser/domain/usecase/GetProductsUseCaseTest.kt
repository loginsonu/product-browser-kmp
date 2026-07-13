package com.sony.productbrowser.domain.usecase

import com.sony.productbrowser.core.result.AppResult
import com.sony.productbrowser.domain.model.Product
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class GetProductsUseCaseTest {

    private val repository = FakeProductRepository()
    private val useCase = GetProductsUseCase(repository)

    @Test
    fun `should return products when repository succeeds`() = runTest {

        val products = listOf(
            Product(
                id = 1,
                title = "iPhone",
                description = "Latest iPhone",
                brand = "Apple",
                price = 999.0,
                rating = 4.8,
                thumbnail = "",
                category = "",
                discountPercentage = 0.0,
                stock = 0,
                images = emptyList()
            )
        )

        repository.result = AppResult.Success(products)

        val result = useCase()

        assertIs<AppResult.Success<List<Product>>>(result)
        assertEquals(products, result.data)
    }

    @Test
    fun `should return error when repository fails`() = runTest {

        repository.result = AppResult.Error("Something went wrong")

        val result = useCase()

        assertIs<AppResult.Error>(result)
        assertEquals("Something went wrong", result.message)
    }
}