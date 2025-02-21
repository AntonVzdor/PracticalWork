package com.example.practicalwork.Screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicalwork.MainActivity
import com.example.practicalwork.Model.DataSource
import com.example.practicalwork.Utils.MyCityNav
import com.example.practicalwork.ViewModel.RecommendationAndDetailsModel

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MyCityApp(){

    val navController = rememberNavController()
    val context = LocalContext.current
    val windowSize = calculateWindowSizeClass(context as MainActivity)
    val viewModel: RecommendationAndDetailsModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val currentRoute = remember { mutableStateOf(MyCityNav.CATEGORY.name) }

    LaunchedEffect(navController.currentBackStackEntry) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            val route = backStackEntry.destination.route ?: MyCityNav.CATEGORY.name
            currentRoute.value = route
            if (route == MyCityNav.CATEGORY.name) {
                viewModel.resetToCategoryScreen()
            }
        }
    }

    Scaffold(
        topBar = {
            TopBarApp(
                title = uiState.title,
                navController = navController,
                showBottomBack = uiState.showBottomBack
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MyCityNav.CATEGORY.name,
        ) {

            composable(route = MyCityNav.CATEGORY.name) {
                CategoryScreen(
                    onClickItem = { categoryData ->
                        viewModel.updateRecommendation(context, categoryData.id)
                        navController.navigate(MyCityNav.RECOMMENDATION.name + "/${categoryData.id}")
                    }
                )
            }

            composable(
                route = MyCityNav.RECOMMENDATION.name + "/{categoryId}",
                arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
            ) {
                if (windowSize.widthSizeClass == WindowWidthSizeClass.Expanded) {
                    RecommendationAndDetails(
                        rec = uiState.details,
                        choiceRecommendation = uiState.currency,
                        onClickItem = { recommendations ->
                            viewModel.updateCurrentDetails(recommendations)
                        }, contentPadding = PaddingValues(), modifier = Modifier.padding(innerPadding)
                    )
                } else {
                    RecommendationScreen(
                        rec = uiState.details,
                        modifier = Modifier.padding(innerPadding),
                        onClickItem = { recommendation ->
                            viewModel.updateRecommendationDetails(context, recommendation.id)
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
                        Modifier.padding(innerPadding)
                        )
                }
            }
        }
    }
}