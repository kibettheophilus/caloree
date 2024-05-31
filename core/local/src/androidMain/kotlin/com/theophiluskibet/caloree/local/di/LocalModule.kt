package com.theophiluskibet.caloree.local.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.theophiluskibet.caloree.local.database.CaloreeDatabase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

actual fun localModule() =
    module {
        single<CaloreeDatabase> { createDatabase(context = get()) }
    }

fun createDatabase(context: Context): CaloreeDatabase {
    val dbFile = context.getDatabasePath("caloree.db")
    return Room.databaseBuilder<CaloreeDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath,
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
