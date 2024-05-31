package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class PriceDTO(
    val price: Double,
    val type: String
)