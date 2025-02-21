package com.example.practicalwork.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practicalwork.R

data class CategoryData(
    val id: Int,
    @StringRes val categoryName: Int,
    @DrawableRes val imageId: Int,
)


data class RecommendationData(
    val id: Int,
    val categoryId: Int,
    @StringRes val recommendationName: Int,
    @StringRes val description: Int,
    @DrawableRes val imageId: Int,
    @DrawableRes val imageDetails: Int
)
