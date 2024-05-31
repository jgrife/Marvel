package com.example.marvel.data.di

import com.example.marvel.data.MarvelRepositoryImpl
import com.example.marvel.data.network.MarvelRemoteApi
import com.example.marvel.data.util.MarvelApiKey
import com.example.marvel.domain.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addConverterFactory(
                json.asConverterFactory("application/json; charset=UTF8".toMediaType())
            )
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(apiKeyInterceptor())
                    .addInterceptor(loggingInterceptor())
                    .build()
            )
            .build()
    }

    private fun apiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            val url = chain
                .request()
                .url
                .newBuilder()
            MarvelApiKey.getAuthKeys().forEach { (authKey, authValue) ->
                url.addQueryParameter(authKey, authValue)
            }
            chain.proceed(chain.request().newBuilder().url(url.build()).build())
        }
    }

    private fun loggingInterceptor(): Interceptor {
        // TODO implement Timber, to prevent logging for release builds
        return HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }

    @Provides
    @Singleton
    fun provideMarvelNetworkApi(retrofit: Retrofit): MarvelRemoteApi {
        return retrofit.create(MarvelRemoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMarvelRepository(marvelRemoteApi: MarvelRemoteApi): MarvelRepository {
        return MarvelRepositoryImpl(marvelRemoteApi)
    }
}