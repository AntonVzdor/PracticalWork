package com.example.practicalwork

import com.example.practicalwork.data.AppDataBase
import android.app.Application

class AirportsApplication : Application() {
    val dataBase: AppDataBase by lazy { AppDataBase.getDatabase(this) }
}