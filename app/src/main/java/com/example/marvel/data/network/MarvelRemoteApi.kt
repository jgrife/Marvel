package com.example.marvel.data.network

import com.example.marvel.data.models.ApiResponse
import com.example.marvel.data.models.ComicDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelRemoteApi {

    @GET("comics/{id}")
    suspend fun getComic(@Path("id") comicId: Int): ApiResponse<ComicDTO>
}