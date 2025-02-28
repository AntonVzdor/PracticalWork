package com.example.practicalwork.ViewModel

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.lifecycle.ViewModel
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class RecommendationAndDetailsModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        DetailsUiState(
            details = DataSource.recommendation,
            currency = DataSource.recommendation.first(),
            title = "MyCite",
            showBottomBack = false
        )
    )

    val uiState: StateFlow<DetailsUiState> = _uiState

    fun updateRecommendation(context: Context, categoryId: Int) {

        val filterRecommendations = DataSource.getCategory(categoryId)
        val categoryName = DataSource.getCategoryName(context, categoryId)

        _uiState.update {
            it.copy(
                details = filterRecommendations,
                currency = filterRecommendations.firstOrNull() ?: RecommendationData(0, 0, 0, 0, 0, 0),
                title = categoryName,
                showBottomBack = true
            )
        }
    }

    fun updateRecommendationDetails(context: Context, categoryId: Int){

        val recommendationName = DataSource.getRecommendationName(context,categoryId)

        _uiState.update {
            it.copy(
                title = recommendationName,
                showBottomBack = true
            )
        }
    }

    fun resetToCategoryScreen() {
        _uiState.update {
            it.copy(
                title = "MyCity",
                showBottomBack = false
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
    val currency: RecommendationData = DataSource.recommendation.first(),
    val title: String = "MyCity",
    val showBottomBack: Boolean = false
)
