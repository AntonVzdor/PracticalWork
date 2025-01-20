package com.example.practicalwork.Screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicalwork.Model.RecommendationSourceList
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
                onClickItem = { navController.navigate(MyCityNav.RECOMMENDATION.name) }
            )
        }
        composable(route = MyCityNav.RECOMMENDATION.name){
            RecommendationScreen(
                rec = RecommendationSourceList.getCoffeeData()
            )
        }
        composable(route = MyCityNav.DESCRIPTION.name) {

        }
    }
}
