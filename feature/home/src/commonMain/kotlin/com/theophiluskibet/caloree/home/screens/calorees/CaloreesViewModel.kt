package com.theophiluskibet.caloree.home.screens.calorees

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theophilus.kibet.caloree.data.sources.CaloreeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CaloreesViewModel(
    private val repository: CaloreeRepository,
) : ViewModel() {
    private val _caloriesState = MutableStateFlow<UiState>(UiState.Default)
    val caloriesState: StateFlow<UiState> = _caloriesState

    fun getCalories(food: String) {
        viewModelScope.launch {
            _caloriesState.update {
                UiState.Loading
            }
            try {
                val result = repository.searchCalories(food)
                _caloriesState.update {
                    UiState.Success(data = result)
                }
                // Log.d("CALORIES", "CALORIESVM: $result")
            } catch (e: Exception) {
                _caloriesState.update {
                    UiState.Error(errorMessage = e.localizedMessage)
                }
                // Log.d("CALORIES", "CALORIESVMErr: ${e.localizedMessage}")
            }
        }
    }
}
