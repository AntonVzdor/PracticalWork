package com.example.practicalwork


import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicalwork.datasource.DataSource
import com.example.practicalwork.uisreen.AccompanimentMenuScreen
import com.example.practicalwork.uisreen.CheckoutScreen
import com.example.practicalwork.uisreen.EntreeMenuScreen
import com.example.practicalwork.uisreen.OrderViewModel
import com.example.practicalwork.uisreen.SideDishMenuScreen
import com.example.practicalwork.uisreen.StartOrderScreen

enum class LunchTrayScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Entree(title = R.string.choose_entree),
    SideMenu(title = R.string.choose_side_dish),
    Accompaniment(title = R.string.choose_accompaniment),
    Checkout(title = R.string.order_checkout)
}

// TODO: AppBar

@Composable
fun LunchTrayApp(
    navController: NavHostController = rememberNavController()
){

    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            // TODO: AppBar
        }
    ){innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = LunchTrayScreen.Start.name,
            modifier = Modifier
        ){
            composable(route = LunchTrayScreen.Start.name){
                StartOrderScreen(
                    onStartOrderButtonClicked = {
                        navController.navigate(LunchTrayScreen.Entree.name)
                    },
                    Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                )
            }

            composable(route = LunchTrayScreen.Entree.name){
                EntreeMenuScreen(
                    options = DataSource.entreeMenuItems,
                    onCancelButtonClicked = {
                        navController.navigate(LunchTrayScreen.Start.name)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.SideMenu.name)
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateEntree(item)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                )
            }

            composable(route = LunchTrayScreen.SideMenu.name){
                SideDishMenuScreen(
                    options = DataSource.sideDishMenuItems,
                    onCancelButtonClicked = {
                        navController.navigate(LunchTrayScreen.Start.name)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Accompaniment.name)
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateSideDish(item)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                )
            }

            composable(route = LunchTrayScreen.Accompaniment.name){
                AccompanimentMenuScreen(
                    options = DataSource.accompanimentMenuItems,
                    onCancelButtonClicked = {
                        navController.navigate(LunchTrayScreen.Start.name)
                    },
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Checkout.name)
                    },
                    onSelectionChanged = { item ->
                        viewModel.updateAccompaniment(item)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                )
            }

            composable(route = LunchTrayScreen.Checkout.name){
                CheckoutScreen(
                    orderUiState = uiState,
                    onNextButtonClicked = {
                        navController.navigate(LunchTrayScreen.Start.name)
                    },
                    onCancelButtonClicked = {
                        navController.navigate(LunchTrayScreen.Start.name)
                    },
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(innerPadding)
                )
            }
        }
    }
}