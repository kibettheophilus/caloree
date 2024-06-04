package com.theophiluskibet.caloree.network.di

import com.theophiluskibet.caloree.network.api.CaloreeApi
import com.theophiluskibet.caloree.network.client.createHttpClient
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
 * [networkModule] provide instances of dependencies needed by classes
 * [platformModule] provides the client specific engine
 */
val networkModule =
    module {
        includes(platformModule())
        single { createHttpClient(engine = get()) }
        single { CaloreeApi(httpClient = get()) }
    }

expect fun platformModule(): Module
