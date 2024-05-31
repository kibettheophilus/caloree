package com.theophilus.kibet.caloree.data.model

/**
 * Data representation used ui
 */
data class Caloree(
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
