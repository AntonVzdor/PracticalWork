package com.example.practicalwork.Utils

import com.example.practicalwork.Model.RecommendationSourceList.getCoffeeData

enum class WindowsStateUtils {
    ListScreen, ListEndDetailScreen
}

enum class ForNavigationApp(){
    COFFEE_RECOMMENDATION {getCoffeeData },
    PARC_RECOMMENDATION {coffeeCategoryAndRecommendationData },
    RESTAURANT_RECOMMENDATION {coffeeCategoryAndRecommendationData },
    CINEMA_RECOMMENDATION {coffeeCategoryAndRecommendationData }
}