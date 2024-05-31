package com.theophiluskibet.caloree.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "caloree_table")
data class CaloreeEntity(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val calories: Double,
    val carbohydratesTotalGrams: Double,
    val cholesterolMilliGrams: Int,
    val fatSaturatedGrams: Double,
    val fatTotalGrams: Double,
    val fiberGrams: Double,
    val potassiumMilliGrams: Int,
    val proteinGrams: Double,
    val servingSizeGrams: Double,
    val sodiumMilliGrams: Int,
    val sugarGrams: Double,
)
