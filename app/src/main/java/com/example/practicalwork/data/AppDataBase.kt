package com.example.practicalwork.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(AirportsData::class), version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun airportsDao(): AirportsDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "airport_database"
                )
                    .createFromAsset("database/airport_database.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
