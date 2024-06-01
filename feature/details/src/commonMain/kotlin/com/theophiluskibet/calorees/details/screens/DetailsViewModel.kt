package com.theophiluskibet.calorees.details.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theophilus.kibet.caloree.data.sources.CaloreeRepository
import com.theophiluskibet.calorees.details.utils.DetailsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val repository: CaloreeRepository,
) : ViewModel() {
    private val _caloreeUiState = MutableStateFlow<DetailsUiState>(DetailsUiState.Default)
    val caloreeUiState: StateFlow<DetailsUiState> = _caloreeUiState

    fun getCaloreeDetails(food: String) {
        _caloreeUiState.update {
            DetailsUiState.Loading
        }
        viewModelScope.launch {
            try {
                val response = repository.searchCalories(query = food)
                _caloreeUiState.update {
                    DetailsUiState.Success(data = response.first())
                }
            } catch (exception: Exception) {
                _caloreeUiState.update {
                    DetailsUiState.Error(errorMessage = exception.message.toString())
                }
            }
        }
    }
}
