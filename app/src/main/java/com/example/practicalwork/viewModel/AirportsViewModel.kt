package com.example.practicalwork.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.practicalwork.AirportsApplication
import com.example.practicalwork.data.AirportsDAO
import com.example.practicalwork.data.AirportsData
import com.example.practicalwork.data.FavoriteDAO
import com.example.practicalwork.data.FavoriteData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AirportsViewModel(
    private val airportsDAO: AirportsDAO,
    private val favoriteDAO: FavoriteDAO
) : ViewModel() {

    fun getAirportByIata(code: String): Flow<List<AirportsData>> =
        airportsDAO.findByIataCode(code)

    fun getFavorites(): Flow<List<FavoriteData>> = favoriteDAO.getAllFavorites()

    fun addToFavorite(airport: AirportsData) = viewModelScope.launch {
        favoriteDAO.addToFavorite(
            FavoriteData(
                id = airport.id,
                name = airport.name,
                iata_code = airport.iata_code,
                passengers = airport.passengers
            )
        )
    }

    fun removeFromFavorite(favorite: FavoriteData) = viewModelScope.launch {
        favoriteDAO.removeFromFavorite(favorite)
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AirportsApplication)
                AirportsViewModel(
                    airportsDAO = application.dataBase.airportsDao(),
                    favoriteDAO = application.dataBase.favoriteDao()
                )
            }
        }
    }
}
