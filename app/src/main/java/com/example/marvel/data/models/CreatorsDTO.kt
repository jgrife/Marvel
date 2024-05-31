package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CreatorsDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<CreatorItemDTO>,
    val returned: Int
)