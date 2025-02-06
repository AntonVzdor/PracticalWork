package com.example.practicalwork.ViewModel

import androidx.lifecycle.ViewModel
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RecommendationAndDetailsModel: ViewModel(){
    private val _uiState = MutableStateFlow(
        DetailsUiState(
            details = DataSource.recommendation,
            currency = DataSource.recommendation.first()
        )
    )

    val uiState: StateFlow<DetailsUiState> = _uiState

    fun updateRecommendation(categoryId: Int){

        val filterRecommendations = DataSource.getCategory(categoryId)

        _uiState.update {
            it.copy(
                details = filterRecommendations,
                currency = filterRecommendations.firstOrNull() ?: RecommendationData(0,0,0,0,0)
            )
        }
    }

    fun updateCurrentDetails(selectedDetail: RecommendationData) {
        _uiState.update {
            it.copy(currency = selectedDetail)
        }
    }
}

data class DetailsUiState(
    val details: List<RecommendationData> = emptyList(),
    val currency: RecommendationData = DataSource.recommendation.first()
)