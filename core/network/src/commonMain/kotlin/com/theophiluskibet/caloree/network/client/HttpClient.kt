package com.theophiluskibet.caloree.network.client

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Creates an http client used when making network calls, extracted so that it can be reused for unit tests
 * [BASE_URL] server base url
 * @param engine
 * @return [HttpClient]
 */

const val BASE_URL = "api.calorieninjas.com/v1"

fun createHttpClient(engine: HttpClientEngine) =
    HttpClient(engine = engine) {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                },
            )
        }

        install(Logging) {
            logger =
                object : Logger {
                    override fun log(message: String) {
                        // log(message)
                    }
                }
            level = LogLevel.ALL
        }

        install(DefaultRequest) {
            url {
                host = BASE_URL
                protocol = URLProtocol.HTTPS
            }
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            header("X-Api-Key", "")
        }
    }
