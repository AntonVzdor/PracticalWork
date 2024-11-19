package com.example.practicalwork.DataSource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practicalwork.R

data class CategoryData(
    @StringRes val categoryId: Int,
    @DrawableRes val imageId: Int
)

object CategorySourceList{
    val defaultCategory = getCategoryData()[0]

    private fun getCategoryData(): List<CategoryData>{
        return listOf(
            CategoryData(
                categoryId = R.string.coffee,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            CategoryData(
                categoryId = R.string.parks,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            CategoryData(
                categoryId = R.string.restaurants,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            CategoryData(
                categoryId = R.string.cinemas,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}