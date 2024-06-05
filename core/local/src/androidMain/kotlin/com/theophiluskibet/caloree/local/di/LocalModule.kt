package com.theophiluskibet.caloree.local.di

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.theophiluskibet.caloree.local.database.CaloreeDatabase
import com.theophiluskibet.caloree.local.database.DB_FILE_NAME
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

/**
 * provides an instance of db implementation in android
 */
actual fun localModule() =
    module {
        single<CaloreeDatabase> { createDatabase(context = get()) }
        // single { get<CaloreeDatabase>().caloreeDao() }
    }

/**
 * creates the db
 * @param context current state of the application
 */
fun createDatabase(context: Context): CaloreeDatabase {
    val dbFile = context.getDatabasePath(DB_FILE_NAME)
    return Room.databaseBuilder<CaloreeDatabase>(
        context = context,
        name = dbFile.absolutePath,
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
