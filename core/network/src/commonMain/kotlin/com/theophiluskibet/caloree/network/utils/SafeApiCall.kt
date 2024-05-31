package com.theophiluskibet.caloree.network

import io.ktor.client.statement.HttpResponse

/**
 * Helper function used when making network calls
 * - [Result] - class provided by kotlin to help propagate success and errors on network calls
 */
internal suspend inline fun <reified T> safeApiCall(block: () -> HttpResponse): Result<T> {
    return try {
        val response = block.invoke()
        Result.success(response)
    } catch (exception: Exception) {
        Result.failure(exception = exception.message)
    }
}
