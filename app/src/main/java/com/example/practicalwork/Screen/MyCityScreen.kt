package com.example.practicalwork.Screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicalwork.MainActivity
import com.example.practicalwork.Model.DataSource
import com.example.practicalwork.Utils.MyCityNav

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MyCityApp(){

    val navController = rememberNavController()
    val context = LocalContext.current
    val windowSize = calculateWindowSizeClass(context as MainActivity)

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
            val choiceRecommendation = recommendations.firstOrNull() ?: return@composable

            if (windowSize.widthSizeClass == WindowWidthSizeClass.Expanded){
                RecommendationAndDetails(
                    rec = recommendations,
                    choiceRecommendation = choiceRecommendation,
                    onClickItem = {

                    }, contentPadding = PaddingValues()
                )
            } else {
                RecommendationScreen(
                    rec = recommendations,
                    onClickItem = { recommendation ->
                        navController.navigate(MyCityNav.DESCRIPTION.name + "/${recommendation.id}")
                    }
                )
            }
        }

        composable(
            route = MyCityNav.DESCRIPTION.name + "/{recommendationId}",
            arguments = listOf(navArgument("recommendationId") { type = NavType.IntType })
        ) { backStackEntry ->
            val recommendationId = backStackEntry.arguments?.getInt("recommendationId")
            val recommendation = DataSource.getRecommendation(recommendationId ?: 0)
            if (recommendation != null) {
                RecommendationDetail(
                    choiceRecommendation = recommendation,
                    contentPadding = PaddingValues()
                )
            }
        }
    }
}
