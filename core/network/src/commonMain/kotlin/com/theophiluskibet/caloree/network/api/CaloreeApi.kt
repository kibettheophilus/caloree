package com.theophiluskibet.caloree.network.api

import com.theophiluskibet.caloree.network.NetworkResult
import com.theophiluskibet.caloree.network.model.CalorieItemsDto
import com.theophiluskibet.caloree.network.safeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**
 * Class used to make network calls
 * @param httpClient provide instance of [HttpClient]
 */
class CaloreeApi(private val httpClient: HttpClient) {
    suspend fun getCalories(query: String): NetworkResult<CalorieItemsDto> =
        safeApiCall {
            httpClient.get("nutrition") {
                parameter("query", query)
            }.body()
        }
}
