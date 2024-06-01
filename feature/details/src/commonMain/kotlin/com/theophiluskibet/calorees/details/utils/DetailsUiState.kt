package com.theophiluskibet.calorees.details.utils

import com.theophilus.kibet.caloree.data.model.Caloree

sealed interface DetailsUiState {
    data object Default : DetailsUiState

    data object Loading : DetailsUiState

    data class Success(val data: Caloree) : DetailsUiState

    data class Error(val errorMessage: String) : DetailsUiState
}
