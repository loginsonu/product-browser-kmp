package com.sony.productbrowser


interface Platform {
    val name: String
}

expect fun getPlatform(): Platform