package com.example.practicalwork.dataSource

import com.example.practicalwork.R
import com.example.practicalwork.model.SuperHero

object HeroesRepository {
    val heroes = listOf(
        SuperHero(
            stringNameRes = R.string.hero1,
            stringDescribeRes = R.string.description1,
            paint = R.drawable.android_superhero1
        ),
        SuperHero(
            stringNameRes = R.string.hero2,
            stringDescribeRes = R.string.description2,
            paint = R.drawable.android_superhero2
        ),
        SuperHero(
            stringNameRes = R.string.hero3,
            stringDescribeRes = R.string.description3,
            paint = R.drawable.android_superhero3
        ),
        SuperHero(
            stringNameRes = R.string.hero4,
            stringDescribeRes = R.string.description4,
            paint = R.drawable.android_superhero4
        ),
        SuperHero(
            stringNameRes = R.string.hero5,
            stringDescribeRes = R.string.description5,
            paint = R.drawable.android_superhero5
        ),
        SuperHero(
            stringNameRes = R.string.hero6,
            stringDescribeRes = R.string.description6,
            paint = R.drawable.android_superhero6
        )
    )
}