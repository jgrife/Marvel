package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class DataDTO<T>(
    val results: List<T>
)