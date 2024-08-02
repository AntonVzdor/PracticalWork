package com.example.practicalwork.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Council(
    val dayNumber: Int,
    @StringRes val nameCouncil: Int,
    @DrawableRes val imageCouncil: Int,
    @StringRes val description: Int
)
