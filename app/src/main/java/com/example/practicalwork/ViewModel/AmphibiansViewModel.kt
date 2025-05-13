package com.example.practicalwork.ViewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicalwork.Data.AmphibianData
import com.example.practicalwork.Network.AmphibianRepo
import kotlinx.coroutines.launch

sealed class UiState{
    object Loading: UiState()
    data class Success(val data: List<AmphibianData>): UiState()
    data class Error(val message: String): UiState()
}

class AmphibiansViewModel: ViewModel() {
    var uiState by mutableStateOf<UiState>(UiState.Loading)
        private set

    private val repository = AmphibianRepo()

    init {
        loadAmphibian()
    }

    fun loadAmphibian(){
        viewModelScope.launch {
            uiState = UiState.Loading
            try {
                val data = repository.fetch()
                uiState = UiState.Success(data)
            } catch (e: Exception){
                uiState = UiState.Error("Ошибка")
            }
        }
    }
}

