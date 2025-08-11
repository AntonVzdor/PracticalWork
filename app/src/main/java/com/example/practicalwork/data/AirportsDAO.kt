package com.example.practicalwork.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportsDAO {
    @Query("SELECT * FROM airport")
    fun getAll(): List<AirportsData>

    @Query("SELECT * FROM airport WHERE name LIKE :name")
    fun findByName(name: String): Flow<List<AirportsData>>
}