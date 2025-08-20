package com.example.practicalwork.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.launch

@Database(entities = [AirportsData::class, FavoriteData::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun airportsDao(): AirportsDAO
    abstract fun favoriteDao(): FavoriteDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "flight_search"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                // Предзаполнение базы
                instance.populateInitialData()
                instance
            }
        }
    }

    private fun populateInitialData() {
        val airports = listOf(
            AirportsData(1, "Francisco Sá Carneiro Airport", "OPO", 5053134),
            AirportsData(2, "Stockholm Arlanda Airport", "ARN", 7494765),
            AirportsData(3, "Warsaw Chopin Airport", "WAW", 18860000),
            AirportsData(4, "Marseille Provence Airport", "MRS", 10151743),
            AirportsData(5, "Milan Bergamo Airport", "BGY", 3833063),
            AirportsData(6, "Vienna International Airport", "VIE", 7812938),
            AirportsData(7, "Sheremetyevo - A.S. Pushkin", "SVO", 49933000)
        )

        kotlinx.coroutines.GlobalScope.launch {
            airportsDao().insertAll(airports)
        }
    }
}
