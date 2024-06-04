package com.theophiluskibet.caloree.network.di

import io.ktor.client.engine.android.Android
import org.koin.dsl.module

/**
 * Provides andoid http client engine
 */
actual fun platformModule() =
    module {
        single { Android.create() }
    }
