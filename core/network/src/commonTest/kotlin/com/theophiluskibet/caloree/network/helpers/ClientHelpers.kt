package com.theophiluskibet.caloree.network.helpers

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headers

/**
 * Generates a mock [HttpClientEngine] to use for testing
 * @param statusCode the status code the response should return
 * @param response the response body as string that the request should return
 * @return [MockEngine]
 */
fun generateFakeEngine(
    statusCode: HttpStatusCode,
    response: String,
) = MockEngine {
    val headers =
        headers {
            append(HttpHeaders.ContentType, "application/json")
        }
    respond(content = response, status = statusCode, headers = headers)
}
