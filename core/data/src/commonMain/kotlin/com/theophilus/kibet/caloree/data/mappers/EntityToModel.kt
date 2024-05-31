package com.theophilus.kibet.caloree.data.mappers

import com.theophilus.kibet.caloree.data.model.Caloree
import com.theophiluskibet.caloree.local.entities.CaloreeEntity

/**
 * Converts database model to ui model
 */
fun CaloreeEntity.toModel() = Caloree(
    name = name,
    calories = calories,
    carbohydratesTotalGrams = carbohydratesTotalGrams,
    cholesterolMilliGrams = cholesterolMilliGrams,
    fatSaturatedGrams = fatSaturatedGrams,
    fatTotalGrams = fatTotalGrams,
    fiberGrams = fiberGrams,
    potassiumMilliGrams = potassiumMilliGrams,
    proteinGrams = proteinGrams,
    servingSizeGrams = servingSizeGrams,
    sodiumMilliGrams = sodiumMilliGrams,
    sugarGrams = sugarGrams
)