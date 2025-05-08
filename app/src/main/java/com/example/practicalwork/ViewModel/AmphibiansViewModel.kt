package com.example.practicalwork.ViewModel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicalwork.Data.AmphibiansDataClass
import com.example.practicalwork.Network.NetworkApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AmphibiansViewModel: ViewModel() {
    private val _uiAmphibians = MutableStateFlow<List<AmphibiansDataClass>>(emptyList())
    val uiAmphibians: StateFlow<List<AmphibiansDataClass>> = _uiAmphibians

    init {
        getAmphibian()
    }
    private fun getAmphibian() {
        viewModelScope.launch {
            try {
                val data = NetworkApi.amphibiansApiService.getAmphibians()
                _uiAmphibians.value = data
            } catch (e: Exception) {
                println("Ошибка в загрузке: ${e.message}")
            }
        }
    }
}

