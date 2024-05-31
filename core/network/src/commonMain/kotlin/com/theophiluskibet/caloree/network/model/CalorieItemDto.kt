package com.theophiluskibet.caloree.network.model

/**
 * Holds a single food item
 */
data class CalorieItemDto(
    val calories: Double,
    val carbohydrates_total_g: Double,
    val cholesterol_mg: Int,
    val fat_saturated_g: Double,
    val fat_total_g: Double,
    val fiber_g: Double,
    val name: String,
    val potassium_mg: Int,
    val protein_g: Double,
    val serving_size_g: Double,
    val sodium_mg: Int,
    val sugar_g: Double,
)
