package com.example.practicalwork.Model

import com.example.practicalwork.Data.CategoryData
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.R

object CategoryDataSource{
    val category = listOf(
        CategoryData(
            id = 1,
            categoryId = R.string.coffee,
            imageId = R.drawable.ic_launcher_foreground
        ),
        CategoryData(
            id = 1,
            categoryId = R.string.parks,
            imageId = R.drawable.ic_launcher_foreground
        ),
        CategoryData(
            id = 1,
            categoryId = R.string.restaurants,
            imageId = R.drawable.ic_launcher_foreground
        ),
        CategoryData(
            id = 1,
            categoryId = R.string.cinemas,
            imageId = R.drawable.ic_launcher_foreground
        )
    )
}


object RecommendationSourceList{

    fun getCoffeeData(): List<RecommendationData>{

        val coffeeCategoryAndRecommendationData = listOf(
            RecommendationData(
                id = 1,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.ReallyCoffee,
                descriptionId = R.string.description1,
            ),
            RecommendationData(
                id = 2,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.OnePriceCoffee,
                descriptionId = R.string.description2,

            ),
            RecommendationData(
                id = 3,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.ChocolateMaker,
                descriptionId = R.string.description3,
            ),
            RecommendationData(
                id = 4,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.CoffeeFix,
                descriptionId = R.string.description4,
            )
        )
        return coffeeCategoryAndRecommendationData
    }

    fun getParcData(): List<RecommendationData>{

        val parcCategoryAndRecommendationData = listOf(
            RecommendationData(
                id = 1,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.GorkyPark,
                descriptionId = R.string.description5,
            ),
            RecommendationData(
                id = 2,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.BotanicalGarden,
                descriptionId = R.string.description6,

                ),
            RecommendationData(
                id = 3,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.SviblovoPark,
                descriptionId = R.string.description7,
            ),
            RecommendationData(
                id = 4,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.Izmailovo,
                descriptionId = R.string.description8,
            )
        )
        return parcCategoryAndRecommendationData
    }

    fun getRestuatantData(): List<RecommendationData>{

        val restaurantCategoryAndRecommendationData = listOf(
            RecommendationData(
                id = 1,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.TastyAndPoint,
                descriptionId = R.string.description9
            ),
            RecommendationData(
                id = 2,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.Murakami,
                descriptionId = R.string.description10,

                ),
            RecommendationData(
                id = 3,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.BurgerHeroes,
                descriptionId = R.string.description11,
            ),
            RecommendationData(
                id = 4,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.Yakitoria,
                descriptionId = R.string.description12,
            )
        )
        return restaurantCategoryAndRecommendationData
    }

    fun getCinemaData(): List<RecommendationData>{

        val cinemaCategoryEndRecommendation = listOf(
            RecommendationData(
                id = 1,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.FiveStars,
                descriptionId = R.string.description13,
            ),
            RecommendationData(
                id = 2,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.Space,
                descriptionId = R.string.description14,

                ),
            RecommendationData(
                id = 3,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.MovieHour,
                descriptionId = R.string.description15,
            ),
            RecommendationData(
                id = 4,
                imageId =  R.drawable.ic_launcher_foreground,
                recommendationId = R.string.Saturn,
                descriptionId = R.string.description16,
            )
        )
        return cinemaCategoryEndRecommendation
    }
}