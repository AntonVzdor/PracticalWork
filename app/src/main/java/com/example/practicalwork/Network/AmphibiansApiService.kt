package com.example.practicalwork.Network

import com.example.practicalwork.Data.AmphibianData
import com.example.practicalwork.Data.AmphibiansDataClass
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object NetworkApi{

    val api: AmphibiansApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(AmphibiansApiService::class.java)
    }
}

interface AmphibiansApiService{
    @GET("amphibians")
    suspend fun getAmphibians(): List<AmphibiansDataClass>
}

class AmphibianRepo{
    suspend fun fetch(): List<AmphibianData> {
        return NetworkApi.api.getAmphibians().map {
            AmphibianData(
                name = it.name,
                type = it.type,
                imgUrl = it.imgUrl,
                description = it.description,
            )
        }
    }
}