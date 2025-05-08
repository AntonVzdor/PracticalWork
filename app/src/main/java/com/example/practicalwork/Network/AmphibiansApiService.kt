package com.example.practicalwork.Network

import com.example.practicalwork.Data.AmphibiansDataClass
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET


object NetworkApi{

    private val json = Json{
        ignoreUnknownKeys = true
    }

    private val contentType = "application/json".toMediaType()

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory(contentType))
        .baseUrl("https://android-kotlin-fun-mars-server.appspot.com")
        .build()

    val amphibiansApiService: AmphibiansApiService = retrofit.create(AmphibiansApiService::class.java)
}

interface AmphibiansApiService{
    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibiansDataClass>
}