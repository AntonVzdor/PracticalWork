package com.example.practicalwork.Screen

import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.practicalwork.Data.CategoryData
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.DataSource
import com.example.practicalwork.Utils.WindowsStateUtils

@Composable
fun AppScreen(
    onClick:(RecommendationData) -> Unit,
    onClickCategory: (CategoryData) -> Unit,
    windowSize: WindowWidthSizeClass
){
    val contentType: WindowsStateUtils = when(windowSize) {
        WindowWidthSizeClass.Compact->{
            WindowsStateUtils.ListScreen
        }
        WindowWidthSizeClass.Medium->{
            WindowsStateUtils.ListScreen
        }
        WindowWidthSizeClass.Expanded->{
            WindowsStateUtils.ListEndDetailScreen
        }
        else ->{
            WindowsStateUtils.ListScreen
        }
    }

    Scaffold {
            innerPadding  ->
        if(contentType == WindowsStateUtils.ListScreen){
            CategoryScreen(
                modifier = Modifier,
                onClickItem = onClickCategory,
                contentPadding = innerPadding
            )
        } else{
            val categoryId = 1
            val recommendations = DataSource.getCategory(categoryId)
            val choiceRecommendation = recommendations.firstOrNull() ?: return@Scaffold

            RecommendationAndDetails(
                rec = recommendations,
                choiceRecommendation = choiceRecommendation,
                onClickItem = onClick,
                contentPadding = innerPadding
            )
        }
    }
}