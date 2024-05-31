package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CreatorItemDTO(
    val name: String,
    val resourceURI: String,
    val role: String
)