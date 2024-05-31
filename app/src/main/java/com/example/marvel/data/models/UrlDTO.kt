package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class UrlDTO(
    val type: String,
    val url: String
)