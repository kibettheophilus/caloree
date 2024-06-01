package com.theophiluskibet.caloree.di

import com.theophiluskibet.calorees.calorees.di.caloreesModule
import com.theophiluskibet.calorees.details.di.detailsModule
import org.koin.dsl.module

val appModule =
    module {
        includes(caloreesModule)
        includes(detailsModule)
    }
