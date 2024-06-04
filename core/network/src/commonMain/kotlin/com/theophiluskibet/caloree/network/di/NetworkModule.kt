package com.theophiluskibet.caloree.network.di

import com.theophiluskibet.caloree.network.api.CaloreeApi
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
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * [BASE_URL] server base url
 * [networkModule] provide instances of dependencies needed by classes
 */
const val BASE_URL = "api.calorieninjas.com/v1"

val networkModule =
    module {
        includes(platformModule())
        single { createHttpClient(engine = get()) }
        single { CaloreeApi(httpClient = get()) }
    }

expect fun platformModule(): Module


fun createHttpClient(engine: HttpClientEngine) = HttpClient(engine = engine) {
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
        header("X-Api-Key", "8/MqBej61B6ALLuEf7cIWg==tJbmaSTQHGZd6wLJ")
    }
}