package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class TextObjectDTO(
    val language: String,
    val text: String,
    val type: String
)