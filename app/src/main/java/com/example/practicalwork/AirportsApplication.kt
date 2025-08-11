package com.example.practicalwork

import com.example.practicalwork.data.AppDataBase

class AirportsApplication {
    val dataBase: AppDataBase by lazy { AppDataBase.getDataBase(this) }
}