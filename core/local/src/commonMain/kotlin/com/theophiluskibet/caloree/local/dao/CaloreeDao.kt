package com.theophiluskibet.caloree.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theophiluskibet.caloree.local.entities.CaloreeEntity

/**
 * api to provide functionality to access the database
 */
@Dao
interface CaloreeDao {
    /**
     * adds a list of calories to db
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCalories(list: List<CaloreeEntity>)

    /**
     * retreives all the available calories from the db
     */
    @Query("SELECT * FROM caloree_table")
    suspend fun getCalories(): List<CaloreeEntity>

    /**
     * retreives a single calorie matching provided name from the db
     */
    @Query("SELECT * FROM caloree_table WHERE name=:name")
    suspend fun getCalory(name: String): CaloreeEntity

    /**
     * retreives a list of calories matching the provided names from the getCaloriesByNames
     * @sample
     * ```
     * val names = listOf("rice","banana")
     *
     * getCalories(names)
     *
     * ```
     */
    @Query("SELECT * FROM caloree_table WHERE name IN(:names)")
    suspend fun getCaloriesByNames(names: List<String>): List<CaloreeEntity>
}
