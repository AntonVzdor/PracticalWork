package com.example.practicalwork.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.practicalwork.AirportsApplication
import com.example.practicalwork.data.AirportsDAO
import com.example.practicalwork.data.AirportsData
import kotlinx.coroutines.flow.Flow

class AirportsViewModel(private val airportsDAO: AirportsDAO): ViewModel() {

    fun getFullAirportList(): Flow<List<AirportsData>> = airportsDAO.getAll()

    fun getAirportByName(name: String): Flow<List<AirportsData>> =
        airportsDAO.findByName(name)

    companion object{
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AirportsApplication)
                AirportsViewModel(application.dataBase.airportsDao())
            }
        }
    }
}