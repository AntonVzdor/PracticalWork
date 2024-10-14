package com.example.practicalwork.data

import androidx.annotation.DrawableRes
import com.example.practicalwork.data.Datasource.dessertList

data class DessertUiState(
    var revenue : Int = 0,
    var dessertsSold : Int = 0,
    val currentDessertIndex: Int = 0,
    var currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes var currentDessertImageId: Int = dessertList[currentDessertIndex].imageId
)
