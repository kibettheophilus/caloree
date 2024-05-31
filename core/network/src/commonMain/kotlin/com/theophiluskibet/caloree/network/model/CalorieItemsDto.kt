package com.theophiluskibet.caloree.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Holds a list of [CalorieItemDto]
 */
@Serializable
data class CalorieItemsDto(
    @SerialName("items")
    val calorieItemsDto: List<CalorieItemDto>,
)
