package com.example.practicalwork.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practicalwork.R



data class PhotoAlbumData(
    @StringRes val namePhoto: Int,
    @DrawableRes val imagePhoto: Int,
    @StringRes val descriptionPhoto: Int
)

object DataSource {
    val photo = listOf(
        PhotoAlbumData(
            namePhoto = R.string.namePhoto1,
            imagePhoto = R.drawable.image_1,
            descriptionPhoto = R.string.descriptionPhoto1
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto2,
            imagePhoto = R.drawable.image_2,
            descriptionPhoto = R.string.descriptionPhoto2
    ) ,
        PhotoAlbumData(
            namePhoto = R.string.namePhoto3,
            imagePhoto = R.drawable.image_3,
            descriptionPhoto = R.string.descriptionPhoto3
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto4,
            imagePhoto = R.drawable.image_4,
            descriptionPhoto = R.string.descriptionPhoto4
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto5,
            imagePhoto = R.drawable.image_5,
            descriptionPhoto = R.string.descriptionPhoto5
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto6,
            imagePhoto = R.drawable.image_6,
            descriptionPhoto = R.string.descriptionPhoto6
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto7,
            imagePhoto = R.drawable.image_7,
            descriptionPhoto = R.string.descriptionPhoto7
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto8,
            imagePhoto = R.drawable.image_8,
            descriptionPhoto = R.string.descriptionPhoto8
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto9,
            imagePhoto = R.drawable.image_9,
            descriptionPhoto = R.string.descriptionPhoto9
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto10,
            imagePhoto = R.drawable.image_10,
            descriptionPhoto = R.string.descriptionPhoto10
        )
    )
}