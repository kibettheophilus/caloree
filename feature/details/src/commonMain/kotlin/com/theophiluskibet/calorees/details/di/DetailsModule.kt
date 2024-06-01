package com.theophiluskibet.calorees.details.di

import com.theophiluskibet.calorees.details.screens.DetailsViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val detailsModule = module {
    viewModelOf(::DetailsViewModel)
}
