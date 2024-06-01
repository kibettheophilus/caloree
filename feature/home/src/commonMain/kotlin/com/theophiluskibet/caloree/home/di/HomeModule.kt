package com.theophiluskibet.caloree.home.di

import com.theophilus.kibet.caloree.data.di.dataModule
import com.theophiluskibet.caloree.home.screens.caloreedetails.CaloreeDetailsViewModel
import com.theophiluskibet.caloree.home.screens.calorees.CaloreesViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val homeModule =
    module {
        includes(dataModule)

        viewModelOf(::CaloreesViewModel)
        viewModelOf(::CaloreeDetailsViewModel)
    }
