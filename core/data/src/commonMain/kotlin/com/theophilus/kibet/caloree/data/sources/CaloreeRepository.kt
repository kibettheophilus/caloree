package com.theophilus.kibet.caloree.data.sources

import com.theophilus.kibet.caloree.data.model.Caloree
import com.theophilus.kibet.caloree.data.model.DataResult
import kotlinx.coroutines.flow.Flow

interface CaloreeRepository {
    suspend fun searchCalories(query: String): Flow<DataResult>
    suspend fun getSavedCalories(): Flow<List<Caloree>>
    suspend fun getCalorieDetails(food: String): Flow<Caloree>
}