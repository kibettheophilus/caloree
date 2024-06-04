package com.theophiluskibet.caloree.network.api

import com.theophiluskibet.caloree.network.di.createHttpClient
import com.theophiluskibet.caloree.network.helpers.apiResponse
import com.theophiluskibet.caloree.network.helpers.generateFakeEngine
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CaloreeApiTest {
    private fun generateFakeApi(statusCode: HttpStatusCode, response: String) =
        CaloreeApi(
            httpClient = createHttpClient(
                generateFakeEngine(
                    statusCode = statusCode,
                    response = response
                )
            )
        )

    @Test
    fun `given CaloreeApi - when getcalorees query is success - returns a body of the search reasult`() =
        runTest {
            val apiCall = generateFakeApi(
                statusCode = HttpStatusCode.OK,
                response = apiResponse
            )

            val response = apiCall.getCalories(query = "rice")

            assertEquals("rice", response.calorieItemsDto.first().name)
        }
}