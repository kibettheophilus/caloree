package com.theophiluskibet.calorees.details.utils

import com.theophilus.kibet.caloree.data.model.Caloree
import com.theophilus.kibet.caloree.data.sources.CaloreeRepository
import kotlinx.coroutines.flow.Flow

class FakeCaloreeRepository : CaloreeRepository {
    override suspend fun searchCalories(query: String): List<Caloree> {
        return listOf(
            Caloree(
                name = "meat",
                calories = 20.0,
                carbohydratesTotalGrams = 20.0,
                cholesterolMilliGrams = 100,
                fatSaturatedGrams = 30.0,
                fatTotalGrams = 44.0,
                fiberGrams = 30.0,
                potassiumMilliGrams = 261,
                proteinGrams = 104.0,
                servingSizeGrams = 100.0,
                sodiumMilliGrams = 127,
                sugarGrams = 68.0,
            )
        )
    }

    override suspend fun getSavedCalories(): Flow<List<Caloree>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCalorieDetails(food: String): Flow<Caloree> {
        TODO("Not yet implemented")
    }
}