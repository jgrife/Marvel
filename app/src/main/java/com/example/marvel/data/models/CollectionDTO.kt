package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CollectionDTO(
    val name: String,
    val resourceURI: String
)