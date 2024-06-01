package com.theophilus.kibet.caloree.data.sources

import com.theophilus.kibet.caloree.data.model.Caloree
import kotlinx.coroutines.flow.Flow

interface CaloreeRepository {
    suspend fun searchCalories(query: String): List<Caloree>

    suspend fun getSavedCalories(): Flow<List<Caloree>>

    suspend fun getCalorieDetails(food: String): Flow<Caloree>
}
