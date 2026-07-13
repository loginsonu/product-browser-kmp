package com.sony.productbrowser.core.result

suspend inline fun <T> safeApiCall(
    crossinline apiCall: suspend () -> T
): AppResult<T> {
    return try {
        AppResult.Success(apiCall())
    } catch (e: Exception) {
        AppResult.Error(
            message = e.message ?: "Something went wrong",
            throwable = e
        )
    }
}