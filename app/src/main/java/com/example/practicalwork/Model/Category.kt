package com.example.practicalwork.Model

import com.example.practicalwork.Data.CategoryData
import com.example.practicalwork.R

object CategorySourceList{
    val defaultCategory = getCategoryData()[0]

    fun getCategoryData(): List<CategoryData>{
        return listOf(
            CategoryData(
                id = 1,
                categoryId = R.string.coffee,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            CategoryData(
                id = 2,
                categoryId = R.string.parks,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            CategoryData(
                id = 3,
                categoryId = R.string.restaurants,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            CategoryData(
                id = 4,
                categoryId = R.string.cinemas,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}