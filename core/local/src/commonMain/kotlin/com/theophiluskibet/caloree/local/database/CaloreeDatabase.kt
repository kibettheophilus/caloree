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

/**
 * Hack copied from
 * https://github.com/joreilly/FantasyPremierLeague/blob/55f35ff9ef2bc25f6c7d42862196990b4a470f17/common/src/commonMain/kotlin/dev/johnoreilly/common/database/AppDatabase.kt#L38
 */
interface DB {
    fun clearAllTables() {}
}
