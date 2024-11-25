package com.example.practicalwork.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RecommendationData(
    @DrawableRes val imageId: Int,
    @StringRes val recommendationId: Int,
    @StringRes val descriptionId: Int
)
