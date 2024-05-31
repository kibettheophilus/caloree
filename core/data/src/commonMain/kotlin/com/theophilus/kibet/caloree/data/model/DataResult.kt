package com.theophilus.kibet.caloree.data.model

/**
 * Utility class to hold network responses i.e success and error states
 */
sealed class DataResult {
    data class Success(val calories: List<Caloree>) : DataResult()
    data class Error(val message: String) : DataResult()
}