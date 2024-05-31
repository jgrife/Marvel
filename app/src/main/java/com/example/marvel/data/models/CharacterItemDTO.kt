package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterItemDTO(
    val name: String,
    val resourceURI: String
)