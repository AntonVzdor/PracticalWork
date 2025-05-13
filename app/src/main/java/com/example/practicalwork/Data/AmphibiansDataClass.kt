package com.example.practicalwork.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AmphibiansDataClass(
    val name: String,
    val type: String,
    @SerialName("img_src") val imgUrl: String,
    val description: String
)

data class AmphibianData(
    val name: String,
    val type: String,
    val imgUrl: String,
    val description: String
)


