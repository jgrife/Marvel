package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class StoriesDTO(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryItemDTO>,
    val returned: Int
)