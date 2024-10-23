package com.theophiluskibet.calorees.details.utils

import com.theophilus.kibet.caloree.data.model.Caloree
import com.theophilus.kibet.caloree.data.sources.CaloreeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeCaloreeRepository : CaloreeRepository {
    var shouldThrowError = false

    override suspend fun searchCalories(query: String): List<Caloree> {
        if (shouldThrowError) {
            throw RuntimeException("An error occured")
        }
        return searchData
    }

    fun simulateError(): List<Caloree> {
        throw Throwable(message = "Error occured")
    }

    override suspend fun getSavedCalories(): Flow<List<Caloree>> {
        return flowOf(searchData)
    }

    override suspend fun getCalorieDetails(food: String): Flow<Caloree> {
        TODO("Not yet implemented")
    }
}

val searchData =
    listOf(
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
        ),
    )
