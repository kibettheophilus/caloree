package com.theophiluskibet.caloree.local.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.theophiluskibet.caloree.local.database.CaloreeDatabase
import com.theophiluskibet.caloree.local.database.instantiateImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.dsl.module
import platform.Foundation.NSHomeDirectory

actual fun localModule() =
    module {
        single<CaloreeDatabase> { createDatabase() }
    }

fun createDatabase(): CaloreeDatabase {
    val dbFilePath = NSHomeDirectory() + "/caloree.db"
    return Room.databaseBuilder<CaloreeDatabase>(
        name = dbFilePath,
        factory = { CaloreeDatabase::class.instantiateImpl() },
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
