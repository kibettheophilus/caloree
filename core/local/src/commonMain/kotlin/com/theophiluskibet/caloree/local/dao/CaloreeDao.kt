package com.theophiluskibet.caloree.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theophiluskibet.caloree.local.entities.CaloreeEntity

@Dao
interface CaloreeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCalories(list: List<CaloreeEntity>)

    @Query("SELECT * FROM caloree_table")
    suspend fun getCalories(): List<CaloreeEntity>

    @Query("SELECT * FROM caloree_table WHERE name=:name")
    suspend fun getCalory(name: String): CaloreeEntity

    @Query("SELECT * FROM caloree_table WHERE name IN(:names)")
    suspend fun getCaloriesByNames(names: List<String>): List<CaloreeEntity>
}
