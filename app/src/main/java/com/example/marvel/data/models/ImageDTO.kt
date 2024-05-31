package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageDTO(
    val extension: String,
    val path: String
)