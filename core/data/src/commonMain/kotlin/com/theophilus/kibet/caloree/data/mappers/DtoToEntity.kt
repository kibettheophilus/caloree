package com.theophilus.kibet.caloree.data.mappers

import com.theophiluskibet.caloree.local.entities.CaloreeEntity
import com.theophiluskibet.caloree.network.model.CalorieItemDto

/**
 * Converts result from network to database model
 */
fun CalorieItemDto.toEntity() = CaloreeEntity(
    name = name,
    calories = calories,
    carbohydratesTotalGrams = carbohydrates_total_g,
    cholesterolMilliGrams = cholesterol_mg,
    fatSaturatedGrams = fat_saturated_g,
    fatTotalGrams = fat_total_g,
    fiberGrams = fiber_g,
    potassiumMilliGrams = potassium_mg,
    proteinGrams = protein_g,
    servingSizeGrams = serving_size_g,
    sodiumMilliGrams = sodium_mg,
    sugarGrams = sugar_g
)