package com.example.practicalwork.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class AirportsData(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "iata_code") val iata_code: String,
    @ColumnInfo(name = "passengers") val passengers: Int
)

@Entity(tableName = "favorite")
data class FavoriteData(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "iata_code") val iata_code: String,
    @ColumnInfo(name = "passengers") val passengers: Int
)

data class RouteData(
    val depart: AirportsData,
    val arrive: AirportsData
)

