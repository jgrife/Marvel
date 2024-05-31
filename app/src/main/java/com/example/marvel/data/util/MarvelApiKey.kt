@file:OptIn(ExperimentalStdlibApi::class)

package com.example.marvel.data.util

import com.example.marvel.BuildConfig
import java.security.MessageDigest
import java.sql.Timestamp

object MarvelApiKey {

    private const val PUBLIC_API_KEY = "75deed5d6c1dd855da763537c7c3df08"

    fun getAuthKeys(
        timestamp: String = Timestamp(System.currentTimeMillis()).time.toString(),
        privateKey: String = BuildConfig.API_KEY,
        publicKey: String = PUBLIC_API_KEY,
    ): Map<String, String> {
        val input = timestamp + privateKey + publicKey

        val md5 = MessageDigest.getInstance("MD5")
        val hash = md5.digest(input.toByteArray()).toHexString()
        return mapOf(
            "ts" to timestamp,
            "apikey" to publicKey,
            "hash" to hash
        )
    }
}