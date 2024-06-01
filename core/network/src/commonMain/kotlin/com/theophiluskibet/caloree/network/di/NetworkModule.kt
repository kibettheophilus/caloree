package com.theophiluskibet.caloree.network.di

import coil3.network.CacheStrategy
import coil3.network.NetworkFetcher
import coil3.network.ktor.asNetworkClient
import com.theophiluskibet.caloree.network.api.CaloreeApi
import io.ktor.client.HttpClient
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
import org.koin.dsl.module

/**
 * [BASE_URL] server base url
 * [networkModule] provide instances of dependencies needed by classes
 */
const val BASE_URL = "api.calorieninjas.com/v1"

val networkModule =
    module {
        single {
            HttpClient {
                install(ContentNegotiation) {
                    json(
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        }
                    )
                }

                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            log(message)
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
        }

        single { CaloreeApi(httpClient = get()) }
        single {
            NetworkFetcher.Factory(
                networkClient = { get<HttpClient>().asNetworkClient() },
                cacheStrategy = { CacheStrategy() }
            )
        }
    }
