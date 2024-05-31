package com.example.marvel.domain

import com.example.marvel.domain.models.Comic
import com.example.marvel.domain.util.DataError
import com.example.marvel.domain.util.Result

interface MarvelRepository {
    suspend fun getComic(comicId: Int): Result<Comic, DataError.Network>
}