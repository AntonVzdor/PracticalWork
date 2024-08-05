package com.example.practicalwork.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PhotoAlbumData(
    @StringRes val namePhoto: Int,
    @DrawableRes val imagePhoto: Int,
    @StringRes val descriptionPhoto: Int
)
