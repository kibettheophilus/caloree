package com.theophiluskibet.caloree.di

import com.theophiluskibet.caloree.home.di.homeModule
import org.koin.dsl.module

val appModule = module {
    includes(homeModule)
}