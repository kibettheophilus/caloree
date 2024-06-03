package com.theophiluskibet.caloree.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.theophiluskibet.caloree.local.dao.CaloreeDao
import com.theophiluskibet.caloree.local.entities.CaloreeEntity

/**
 * used to create the database
 * @param entities list of available tables in the app
 * @param version current version of the db
 */
@Database(entities = [CaloreeEntity::class], version = 1)
abstract class CaloreeDatabase : RoomDatabase(), DB {
    abstract fun caloreeDao(): CaloreeDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

interface DB {
    fun clearAllTables(): Unit {}
}
