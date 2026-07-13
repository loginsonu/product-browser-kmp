package com.sony.productbrowser.presentation.preview

import com.sony.productbrowser.domain.model.Product

object PreviewData {

    val products = listOf(

        Product(
            id = 1,
            title = "iPhone 16 Pro Max",
            description = "Apple's latest flagship smartphone.",
            category = "smartphones",
            brand = "Apple",
            price = 1499.99,
            discountPercentage = 10.5,
            rating = 4.8,
            stock = 12,
            thumbnail = "https://cdn.dummyjson.com/product-images/smartphones/iphone-16-pro-max/thumbnail.webp",
            images = listOf(
                "https://cdn.dummyjson.com/product-images/smartphones/iphone-16-pro-max/1.webp"
            )
        ),

        Product(
            id = 2,
            title = "Samsung Galaxy S25 Ultra",
            description = "Samsung premium flagship device.",
            category = "smartphones",
            brand = "Samsung",
            price = 1399.99,
            discountPercentage = 8.0,
            rating = 4.7,
            stock = 18,
            thumbnail = "https://cdn.dummyjson.com/product-images/smartphones/samsung-galaxy-s25-ultra/thumbnail.webp",
            images = listOf(
                "https://cdn.dummyjson.com/product-images/smartphones/samsung-galaxy-s25-ultra/1.webp"
            )
        ),

        Product(
            id = 3,
            title = "Google Pixel 10",
            description = "Google AI powered smartphone.",
            category = "smartphones",
            brand = "Google",
            price = 999.99,
            discountPercentage = 5.0,
            rating = 4.6,
            stock = 15,
            thumbnail = "https://cdn.dummyjson.com/product-images/smartphones/google-pixel-10/thumbnail.webp",
            images = listOf(
                "https://cdn.dummyjson.com/product-images/smartphones/google-pixel-10/1.webp"
            )
        ),

        Product(
            id = 4,
            title = "Nothing Phone 3",
            description = "Minimalistic Android smartphone.",
            category = "smartphones",
            brand = "Nothing",
            price = 799.99,
            discountPercentage = 6.5,
            rating = 4.5,
            stock = 10,
            thumbnail = "https://cdn.dummyjson.com/product-images/smartphones/nothing-phone-3/thumbnail.webp",
            images = listOf(
                "https://cdn.dummyjson.com/product-images/smartphones/nothing-phone-3/1.webp"
            )
        )

    )
}