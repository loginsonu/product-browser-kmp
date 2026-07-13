package com.sony.productbrowser.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class HttpClientFactory {

    private val client by lazy {
        HttpClient {
            expectSuccess = true
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        explicitNulls = false
                        isLenient = true
                    }
                )
            }

            install(Logging) {
                level = LogLevel.INFO
            }

            install(DefaultRequest) {
                url(NetworkConstants.BASE_URL)
            }
        }
    }

    fun create(): HttpClient = client
}