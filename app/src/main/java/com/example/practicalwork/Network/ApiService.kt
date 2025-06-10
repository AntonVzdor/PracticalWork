package com.example.practicalwork.Network

import com.example.practicalwork.Data.BookList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiService {
    val bookApi: GoogleBookApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GoogleBookApi::class.java)
    }
}

interface GoogleBookApi {
    @GET("volumes")
    suspend fun searchBook(@Query("q") query: String): BookList
}