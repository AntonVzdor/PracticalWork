package com.example.practicalwork.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class SuperHero(
    @StringRes val stringNameRes: Int,
    @StringRes val stringDescribeRes: Int,
    @DrawableRes val paint: Int
)
