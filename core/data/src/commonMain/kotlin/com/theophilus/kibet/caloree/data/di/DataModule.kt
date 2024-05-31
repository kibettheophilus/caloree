package com.theophilus.kibet.caloree.data.di

import com.theophilus.kibet.caloree.data.sources.CaloreeRepository
import com.theophiluskibet.caloree.local.di.localModule
import com.theophiluskibet.caloree.network.di.networkModule
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * [dataModule] provide instances of dependencies needed by classes
 * loads local and network module using [localModule] and [networkModule] respectively
 */
val dataModule = module {
    includes(listOf(localModule(), networkModule))

    singleOf(::CaloreeRepositoryImpl) { bind<CaloreeRepository> }
}