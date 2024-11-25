package com.example.practicalwork.Data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CategoryData(
    val id: Int,
    @StringRes val categoryId: Int,
    @DrawableRes val imageId: Int
)
