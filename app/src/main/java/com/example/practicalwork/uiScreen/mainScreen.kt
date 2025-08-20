package com.example.practicalwork.uiScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practicalwork.data.AirportsData
import com.example.practicalwork.data.RouteData
import com.example.practicalwork.viewModel.AirportsViewModel

@Composable
fun MainScreenApp(
    airportsViewModel: AirportsViewModel = viewModel(factory = AirportsViewModel.factory)
) {
    var query by remember { mutableStateOf("") }

    // Результаты поиска
    val searchResults by airportsViewModel.getAirportByIata(query)
        .collectAsState(initial = emptyList())

    // Избранное
    val favorites by airportsViewModel.getFavorites()
        .collectAsState(initial = emptyList())

    // Если есть поиск — показываем результаты, иначе показываем избранное
    val displayList = if (query.isNotEmpty()) {
        searchResults.map { RouteData(it, it) }
    } else {
        favorites.map { fav ->
            val airport = AirportsData(fav.id, fav.name, fav.iata_code, fav.passengers)
            RouteData(airport, airport)
        }
    }


    Scaffold(
        topBar = { TopBarMainScreen() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Enter IATA code") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

            LazyColumn {
                items(displayList) { route ->
                    InfoBlock(
                        route = route,
                        onFavoriteClick = {
                            val existing = favorites.find { it.id == route.depart.id }
                            if (existing != null) {
                                airportsViewModel.removeFromFavorite(existing)
                            } else {
                                airportsViewModel.addToFavorite(route.depart)
                            }
                        }
                    )
                }
            }
        }
    }
}
