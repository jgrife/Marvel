package com.example.marvel.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    val data: DataDTO<T>
)