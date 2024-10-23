package com.theophiluskibet.calorees.calorees.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theophilus.kibet.caloree.data.sources.CaloreeRepository
import com.theophiluskibet.calorees.calorees.utils.CaloreesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CaloreesViewModel(
    private val repository: CaloreeRepository,
) : ViewModel() {
    private val _caloriesState = MutableStateFlow<CaloreesUiState>(CaloreesUiState.Default)
    val caloriesState: StateFlow<CaloreesUiState> = _caloriesState

    init {
        getSaved()
    }

    fun getCalories(food: String) {
        viewModelScope.launch {
            _caloriesState.update {
                CaloreesUiState.Loading
            }
            try {
                val result = repository.searchCalories(food)
                _caloriesState.update {
                    CaloreesUiState.Success(data = result)
                }
            } catch (exception: Exception) {
                _caloriesState.update {
                    CaloreesUiState.Error(errorMessage = exception.message.toString())
                }
            }
        }
    }

    private fun getSaved() {
        viewModelScope.launch {
            _caloriesState.update {
                CaloreesUiState.Loading
            }
            try {
                repository.getSavedCalories().collect { result ->
                    _caloriesState.update {
                        CaloreesUiState.Success(data = result)
                    }
                }
            } catch (exception: Exception) {
                _caloriesState.update {
                    CaloreesUiState.Error(errorMessage = exception.message.toString())
                }
            }
        }
    }
}
