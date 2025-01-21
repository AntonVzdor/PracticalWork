package com.example.practicalwork.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicalwork.Model.DataSource
import com.example.practicalwork.Utils.MyCityNav

@Composable
fun MyCityApp(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MyCityNav.CATEGORY.name,
    ){

        composable(route = MyCityNav.CATEGORY.name){
            CategoryScreen(
                onClickItem = {categoryData ->
                    navController.navigate(MyCityNav.RECOMMENDATION.name + "/${categoryData.id}")
                }
            )
        }

        composable(
            route = MyCityNav.RECOMMENDATION.name + "/{categoryId}",
            arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getInt("categoryId")
            val recommendations = DataSource.getCategory(categoryId ?: 0)
            RecommendationScreen(
                rec = recommendations,
                onClickItem = { recommendation ->
                    navController.navigate(MyCityNav.DESCRIPTION.name + "/${recommendation.id}")
                }
            )
        }

        composable(
            route = MyCityNav.DESCRIPTION.name + "/{recommendationId}",
            arguments = listOf(navArgument("recommendationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recommendationId = backStackEntry.arguments?.getInt("recommendationId")
            val recommendation = DataSource.getRecommendation(recommendationId ?: 0)
            if (recommendation != null) {
                RecommendationDetail(
                    choiceRecommendation = recommendation
                )
            }
        }
    }
}
