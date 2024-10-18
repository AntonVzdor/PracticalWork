package com.example.practicalwork.data

import com.example.practicalwork.R


object Datasource {
    val dessertList = listOf(
        Dessert(R.drawable.cupcake, 2, 0),
        Dessert(R.drawable.donut, 10, 3),
        Dessert(R.drawable.eclair, 1, 6),
        Dessert(R.drawable.froyo, 6, 9),
        Dessert(R.drawable.gingerbread, 7, 12),
        Dessert(R.drawable.honeycomb, 8, 15),
        Dessert(R.drawable.icecreamsandwich, 9, 17),
        Dessert(R.drawable.jellybean, 12, 20),
        Dessert(R.drawable.kitkat, 15, 23),
        Dessert(R.drawable.lollipop, 3, 26),
        Dessert(R.drawable.marshmallow, 2, 29),
        Dessert(R.drawable.nougat, 10, 32),
        Dessert(R.drawable.oreo, 5, 35)
    )
}

data class Dessert(val imageId: Int, val price: Int, val startProductionAmount: Int)