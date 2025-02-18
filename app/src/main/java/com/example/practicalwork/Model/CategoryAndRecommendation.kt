package com.example.practicalwork.Model

import android.content.Context
import com.example.practicalwork.Data.CategoryData
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.R

object DataSource{
    val category = listOf(
        //категории
        CategoryData(
            id = 1,
            categoryName = R.string.coffee,
            imageId = R.drawable.coffee_cup_3113098
        ),
        CategoryData(
            id = 2,
            categoryName = R.string.parks,
            imageId = R.drawable.park_4814542
        ),
        CategoryData(
            id = 3,
            categoryName = R.string.restaurants,
            imageId = R.drawable.hamburger_3075977
        ),
        CategoryData(
            id = 4,
            categoryName = R.string.cinemas,
            imageId = R.drawable.cinema_2281341
        )
    )

    val recommendation = listOf(
        //кофе
        RecommendationData(
            id = 1,
            categoryId = 1,
            recommendationName = R.string.ReallyCoffee,
            description = R.string.description1,
            imageId = R.drawable.ic_launcher_foreground
            ),
        RecommendationData(
            id = 2,
            categoryId = 1,
            recommendationName = R.string.OnePriceCoffee,
            description = R.string.description2,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 3,
            categoryId = 1,
            recommendationName = R.string.ChocolateMaker,
            description = R.string.description3,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 4,
            categoryId = 1,
            recommendationName = R.string.CoffeeFix,
            description = R.string.description4,
            imageId = R.drawable.ic_launcher_foreground
        ),
        //парки
        RecommendationData(
            id = 5,
            categoryId = 2,
            recommendationName = R.string.GorkyPark,
            description = R.string.description5,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 6,
            categoryId = 2,
            recommendationName = R.string.BotanicalGarden,
            description = R.string.description6,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 7,
            categoryId = 2,
            recommendationName = R.string.SviblovoPark,
            description = R.string.description7,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 8,
            categoryId = 2,
            recommendationName = R.string.Izmailovo,
            description = R.string.description8,
            imageId = R.drawable.ic_launcher_foreground
        ),
        //рестораны
        RecommendationData(
            id = 9,
            categoryId = 3,
            recommendationName = R.string.TastyAndPoint,
            description = R.string.description9,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 10,
            categoryId = 3,
            recommendationName = R.string.Murakami,
            description = R.string.description10,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 11,
            categoryId = 3,
            recommendationName = R.string.BurgerHeroes,
            description = R.string.description11,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 12,
            categoryId = 3,
            recommendationName = R.string.Yakitoria,
            description = R.string.description12,
            imageId = R.drawable.ic_launcher_foreground
        ),
        //кинотеатры
        RecommendationData(
            id = 13,
            categoryId = 4,
            recommendationName = R.string.FiveStars,
            description = R.string.description13,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 14,
            categoryId = 4,
            recommendationName = R.string.Space,
            description = R.string.description14,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 15,
            categoryId = 4,
            recommendationName = R.string.MovieHour,
            description = R.string.description15,
            imageId = R.drawable.ic_launcher_foreground
        ),
        RecommendationData(
            id = 16,
            categoryId = 4,
            recommendationName = R.string.Saturn,
            description = R.string.description16,
            imageId = R.drawable.ic_launcher_foreground
        )
    )

    fun getCategory(category: Int): List<RecommendationData>{
        return recommendation.filter { it.categoryId == category }
    }

    fun getCategoryName(context: Context, categoryId: Int): String {
        val category = DataSource.category.find { it.id == categoryId }
        return category?.categoryName?.let { context.getString(it) } ?: "Неизвестная категория"
    }

    fun getRecommendationName(context: Context, categoryId: Int): String {
        val recommendation = DataSource.recommendation.find { it.id == categoryId }
        return recommendation?.recommendationName?.let { context.getString(it) } ?: "Неизвестная категория"
    }

    fun getRecommendation(recommendationId: Int): RecommendationData?{
        return recommendation.find { it.id == recommendationId }
    }
}