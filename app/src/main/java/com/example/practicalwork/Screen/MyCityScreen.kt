package com.example.practicalwork.Screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.practicalwork.Utils.MyCity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practicalwork.Data.CategoryData
import com.example.practicalwork.Data.RecommendationData
import com.example.practicalwork.Model.RecommendationSourceList

@Composable
fun MyCityApp(){
    Scaffold(
    ) { innerPadding ->
    NavHost(
        navController = navController,
        startDestination = MyCity.CATEGORY.name,
        modifier = Modifier.padding(innerPadding)
    ){
        composable(route = MyCity.CATEGORY.name){
            CategoryScreen(
                onClick = {}
            )
        }
        composable(route = MyCity.RECOMMENDATION.name){
            val context = LocalContext.current
            RecommendationScreen(
                rec = RecommendationSourceList.getCoffeeData()
            )
        }
        /*composable(route = MyCity.DESCRIPTION.name){
            val context = LocalContext.current
            RecommendationDetail(
                choiceRecommendation = RecommendationData()
            )
        }*/
    }
}
}