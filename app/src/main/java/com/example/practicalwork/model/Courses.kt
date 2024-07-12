package com.example.practicalwork.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Courses(
    @StringRes val stringResourceId: Int,
    val numberResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
