package com.theophiluskibet.calorees.calorees.utils

import com.theophilus.kibet.caloree.data.model.Caloree

sealed interface CaloreesUiState {
    data object Loading : CaloreesUiState

    data object Default : CaloreesUiState

    data class Success(val data: List<Caloree>) : CaloreesUiState

    data class Error(val errorMessage: String) : CaloreesUiState
}
