package com.theophilus.kibet.caloree.data.sources

import com.theophilus.kibet.caloree.data.mappers.toEntity
import com.theophilus.kibet.caloree.data.mappers.toModel
import com.theophilus.kibet.caloree.data.model.Caloree
import com.theophilus.kibet.caloree.data.model.DataResult
import com.theophiluskibet.caloree.local.dao.CaloreeDao
import com.theophiluskibet.caloree.network.api.CaloreeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CaloreeRepositoryImpl(
    private val caloreeApi: CaloreeApi,
    private val caloreeDao: CaloreeDao
) : CaloreeRepository {
    /**
     * Retreives a list of calories from db if matches the query else fetch from network
     *
     * 1. Splits the query into a list of food names, removing "and" and trims whitespace then
     *    retrieves data from database, this is because "and" isn't saved in db.
     * 2. If data is not available in db, fetch from network taking the whole query. Unlike db, the
     *    api accepts "and" and will return a list of calories.
     * @param query food to retrieve calories
     * @sample
     * ```
     * val query = "food and banana"
     * caloreeDao.getCaloriesByNames(food,banana) // from db
     * caloreeApi.getCalories(food and banana) // from network
     * ```
     */
    override suspend fun searchCalories(query: String): Flow<DataResult> {
        val listOfFoods = query.replace("and", "").trim().split(" ")
        val calories = caloreeDao.getCaloriesByNames(listOfFoods)
        return if (calories.size == listOfFoods.size) {
            flowOf(DataResult.Success(calories = calories))
        } else {
            val response = caloreeApi.getCalories(query = query)
            response.onSuccess { result ->
                caloreeDao.saveCalories(result.calorieItemsDto.map { it.toEntity() })
                flowOf(DataResult.Success(calories = result.calorieItemsDto.map {
                    it.toEntity().toModel()
                }))
            }
            response.onFailure { error ->
                flowOf(DataResult.Error(message = error.message))
            }
        }
    }

    /**
     * retreives a list of calories saved in the db
     */
    override suspend fun getSavedCalories(): Flow<List<Caloree>> {
        return flowOf(caloreeDao.getCalories().map { it.toModel() })
    }

    /**
     * retreives details of a single calorie saved in the db
     * @param food name of the calorie
     */
    override suspend fun getCalorieDetails(food: String): Flow<Caloree> {
        return flowOf(caloreeDao.getCaloryDetails(name = food).toModel())
    }
}