package com.theophiluskibet.caloree.network.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
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
const val BASE_URL = "https://api.calorieninjas.com/v1/"

val networkModule =
    module {
        single {
            HttpClient {
                install(ContentNegotiation) {
                    json {
                        Json {
                            ignoreUnknownKeys = true
                            isLenient = true
                        }
                    }
                }

                install(DefaultRequest) {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = BASE_URL
                    }
                    header(HttpHeaders.ContentType, ContentType.Application.Json)
                    header("X-Api-Key", "8/MqBej61B6ALLuEf7cIWg==tJbmaSTQHGZd6wLJ")
                }
            }
        }
    }
