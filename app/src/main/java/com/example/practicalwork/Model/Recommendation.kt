package com.example.practicalwork.Model

import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.R

object CoffeeRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    fun getRecommendationData(): List<RecommendationData>{
        return listOf(
            RecommendationData(
                id = 1,
                recommendationId = R.string.ReallyCoffee,
                descriptionId = R.string.description1,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                id = 2,
                recommendationId = R.string.OnePriceCoffee,
                descriptionId = R.string.description2,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                id = 3,
                recommendationId = R.string.ChocolateMaker,
                descriptionId = R.string.description3,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                id = 4,
                recommendationId = R.string.CoffeeFix,
                descriptionId = R.string.description4,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}

/*object ParksRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<RecommendationData>{
        return listOf(
            RecommendationData(
                recommendationId = R.string.GorkyPark,
                descriptionId = R.string.description5,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.BotanicalGarden,
                descriptionId = R.string.description6,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.SviblovoPark,
                descriptionId = R.string.description7,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.Izmailovo,
                descriptionId = R.string.description8,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}

object RestaurantsRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<RecommendationData>{
        return listOf(
            RecommendationData(
                recommendationId = R.string.TastyAndPoint,
                descriptionId = R.string.description9,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.Murakami,
                descriptionId = R.string.description10,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.BurgerHeroes,
                descriptionId = R.string.description11,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.Yakitoria,
                descriptionId = R.string.description12,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}

object CinemasRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<RecommendationData>{
        return listOf(
            RecommendationData(
                recommendationId = R.string.FiveStars,
                descriptionId = R.string.description13,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.Space,
                descriptionId = R.string.description14,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.MovieHour,
                descriptionId = R.string.description15,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            RecommendationData(
                recommendationId = R.string.Saturn,
                descriptionId = R.string.description16,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}
*/