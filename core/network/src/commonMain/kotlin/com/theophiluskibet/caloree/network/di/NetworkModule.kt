package com.theophiluskibet.caloree.network.di

import com.theophiluskibet.caloree.network.api.CaloreeApi
import com.theophiluskibet.caloree.network.client.createHttpClient
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
