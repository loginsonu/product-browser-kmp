package com.sony.productbrowser.data.remote.mapper

import com.sony.productbrowser.data.remote.dto.ProductDto
import com.sony.productbrowser.domain.model.Product

fun ProductDto.toDomain(): Product =
    Product(
        id = id,
        title = title,
        description = description,
        category = category,
        brand = brand.orEmpty(),
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        thumbnail = thumbnail,
        images = images
    )