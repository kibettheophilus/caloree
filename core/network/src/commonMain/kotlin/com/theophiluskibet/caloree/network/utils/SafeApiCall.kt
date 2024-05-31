package com.theophiluskibet.caloree.network

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

sealed interface NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>
    data class Error(val message: String) : NetworkResult<Nothing>
}

/**
 * Helper function used when making network calls
 * - [Result] - class provided by kotlin to help propagate success and errors on network calls
 */
suspend inline fun <reified T> safeApiCall(block: () -> HttpResponse): NetworkResult<T> {
    return try {
        val response = block.invoke()
        NetworkResult.Success(data = response.body())
    } catch (exception: Exception) {
        NetworkResult.Error(message = exception.message ?: "An error occured")
    }
}
