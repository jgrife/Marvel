package com.example.marvel.data

import com.example.marvel.data.models.toComic
import com.example.marvel.data.network.MarvelRemoteApi
import com.example.marvel.domain.MarvelRepository
import com.example.marvel.domain.models.Comic
import com.example.marvel.domain.util.DataError
import com.example.marvel.domain.util.Result
import kotlinx.coroutines.ensureActive
import okio.IOException
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class MarvelRepositoryImpl @Inject constructor(
    private val remoteApi: MarvelRemoteApi
) : MarvelRepository {

    override suspend fun getComic(comicId: Int): Result<Comic, DataError.Network> {
        return try {
            val result = remoteApi.getComic(comicId)
            val comic = result.data.results.getOrNull(0)?.toComic() ?: throw IOException()
            Result.Success(comic)
        } catch (ex: Exception) {
            // rethrowing CancellationException, if this was a coroutine cancellation
            coroutineContext.ensureActive()
            // NOTE: just hardcoding one Network Error here
            // TODO this mapping from exception thrown OR from http error status codes, should be handled once for ALL network responses.
            Result.Error(DataError.Network.SERVER_ERROR)
        }
    }
}