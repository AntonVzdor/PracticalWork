package com.example.practicalwork.Data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class AmphibiansDataClass(
    val name: String,
    val type: String,
    val description: String,
    val imgUrl: String
)
