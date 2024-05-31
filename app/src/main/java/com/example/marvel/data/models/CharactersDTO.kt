package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CharactersDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<CharacterItemDTO>,
    val returned: Int
)