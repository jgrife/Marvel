package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class EventsDTO(
    val available: Int,
    val collectionURI: String,
    val returned: Int
)