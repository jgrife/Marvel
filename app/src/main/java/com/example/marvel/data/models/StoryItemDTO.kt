package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class StoryItemDTO(
    val name: String,
    val resourceURI: String,
    val type: String
)