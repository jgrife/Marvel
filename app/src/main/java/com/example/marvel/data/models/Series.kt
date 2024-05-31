package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Series(
    val name: String,
    val resourceURI: String
)