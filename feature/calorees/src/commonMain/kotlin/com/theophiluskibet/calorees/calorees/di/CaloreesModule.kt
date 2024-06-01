package com.theophiluskibet.calorees.calorees.di

import com.theophilus.kibet.caloree.data.di.dataModule
import com.theophiluskibet.calorees.calorees.screens.CaloreesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val caloreesModule =
    module {
        includes(dataModule)

        viewModelOf(::CaloreesViewModel)
    }
