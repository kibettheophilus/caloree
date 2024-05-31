package com.theophiluskibet.caloree.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.theophiluskibet.caloree.local.dao.CaloreeDao
import com.theophiluskibet.caloree.local.entities.CaloreeEntity

@Database(entities = [CaloreeEntity::class], version = 1)
abstract class CaloreeDatabase : RoomDatabase() {
    abstract fun caloreeDao(): CaloreeDao
}
