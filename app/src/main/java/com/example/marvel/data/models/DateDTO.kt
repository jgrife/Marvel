package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class DateDTO(
    val date: String,
    val type: String
)