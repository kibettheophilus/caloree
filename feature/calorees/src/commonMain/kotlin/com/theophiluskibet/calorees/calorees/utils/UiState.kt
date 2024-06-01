package com.theophiluskibet.calorees.calorees.utils

import com.theophilus.kibet.caloree.data.model.Caloree

sealed interface UiState {
    data object Loading : UiState

    data object Default : UiState

    data class Success(val data: List<Caloree>) : UiState

    data class Error(val errorMessage: String) : UiState
}
