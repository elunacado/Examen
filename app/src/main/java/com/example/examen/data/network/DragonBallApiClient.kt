package com.example.examen.data.network

import android.util.Log
import com.example.examen.data.network.model.DragonBallObject

class DragonBallApiClient {
    private lateinit var api: DragonBallApiService

    suspend fun getCharactersList(limit: Int): List<DragonBallObject>? {
        Log.d("DragonBallApiClient", "getCharactersList called with limit: $limit")
        api = NetworkModuleDI()
        return try {
            val response = api.getCharactersList(limit)
            val result = response.items
            Log.d("DragonBallApiClient", "getCharactersList result: ${result?.size ?: 0} items")
            result
        } catch (e: java.lang.Exception) {
            Log.e("DragonBallApiClient", "Error fetching characters list", e)
            e.printStackTrace()
            null
        }
    }

    suspend fun getCharacterInfo(numberCharacter: Int): DragonBallObject? {
        Log.d("DragonBallApiClient", "getCharacterInfo called with numberCharacter: $numberCharacter")
        api = NetworkModuleDI()
        return try {
            val result = api.getCharacterInfo(numberCharacter)
            Log.d("DragonBallApiClient", "getCharacterInfo result: ${result?.name ?: "null"}")
            result
        } catch (e: java.lang.Exception) {
            Log.e("DragonBallApiClient", "Error fetching character info", e)
            e.printStackTrace()
            null
        }
    }
}