package com.example.practicalwork.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportsDAO {
    @Query("SELECT * FROM airport")
    fun getAll(): Flow<List<AirportsData>>

    @Query("SELECT * FROM airport WHERE iata_code LIKE '%' || :code || '%' COLLATE NOCASE")
    fun findByIataCode(code: String): Flow<List<AirportsData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(airports: List<AirportsData>)
}

@Dao
interface FavoriteDAO {
    @Query("SELECT * FROM favorite")
    fun getAllFavorites(): Flow<List<FavoriteData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(favorite: FavoriteData)

    @Delete
    suspend fun removeFromFavorite(favorite: FavoriteData)
}
