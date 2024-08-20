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
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image1,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image2,
            descriptionPhoto = R.string.descriptionPhoto
    ) ,
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image3,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image4,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image5,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image6,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image7,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image8,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image9,
            descriptionPhoto = R.string.descriptionPhoto
        ),
        PhotoAlbumData(
            namePhoto = R.string.namePhoto,
            imagePhoto = R.drawable.image10,
            descriptionPhoto = R.string.descriptionPhoto
        )
    )
}