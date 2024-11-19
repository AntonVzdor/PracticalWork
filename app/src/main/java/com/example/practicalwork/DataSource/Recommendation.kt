package com.example.practicalwork.DataSource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.practicalwork.R

data class Recommendation(
    @DrawableRes val imageId: Int,
    @StringRes val recommendationId: Int,
    @StringRes val descriptionId: Int
)

object CoffeeRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<Recommendation>{
        return listOf(
            Recommendation(
                recommendationId = R.string.ReallyCoffee,
                descriptionId = R.string.description1,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.OnePriceCoffee,
                descriptionId = R.string.description2,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.ChocolateMaker,
                descriptionId = R.string.description3,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.CoffeeFix,
                descriptionId = R.string.description4,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}

object ParksRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<Recommendation>{
        return listOf(
            Recommendation(
                recommendationId = R.string.GorkyPark,
                descriptionId = R.string.description5,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.BotanicalGarden,
                descriptionId = R.string.description6,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.SviblovoPark,
                descriptionId = R.string.description7,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.Izmailovo,
                descriptionId = R.string.description8,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}

object RestaurantsRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<Recommendation>{
        return listOf(
            Recommendation(
                recommendationId = R.string.TastyAndPoint,
                descriptionId = R.string.description9,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.Murakami,
                descriptionId = R.string.description10,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.BurgerHeroes,
                descriptionId = R.string.description11,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.Yakitoria,
                descriptionId = R.string.description12,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}

object CinemasRecommendationSourceList{
    val defaultRecommendation = getRecommendationData()[0]

    private fun getRecommendationData(): List<Recommendation>{
        return listOf(
            Recommendation(
                recommendationId = R.string.FiveStars,
                descriptionId = R.string.description13,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.Space,
                descriptionId = R.string.description14,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.MovieHour,
                descriptionId = R.string.description15,
                imageId =  R.drawable.ic_launcher_foreground
            ),
            Recommendation(
                recommendationId = R.string.Saturn,
                descriptionId = R.string.description16,
                imageId =  R.drawable.ic_launcher_foreground
            )
        )
    }
}
