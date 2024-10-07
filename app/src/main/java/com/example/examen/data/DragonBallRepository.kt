package com.example.examen.data

import android.util.Log
import com.example.examen.data.network.DragonBallApiClient
import com.example.examen.data.network.model.DragonBallObject

class DragonBallRepository {
    private val apiDragonBall = DragonBallApiClient()

    suspend fun getDragonBallList(limit: Int): List<DragonBallObject>? {
        Log.d("DragonBallRepository", "getDragonBallList called with limit: $limit")
        val result = apiDragonBall.getCharactersList(limit)
        Log.d("DragonBallRepository", "getDragonBallList result: ${result?.size ?: 0} items")
        return result
    }

    suspend fun getDragonBallInfo(numberCharacter: Int): DragonBallObject? {
        Log.d("DragonBallRepository", "getDragonBallInfo called with numberCharacter: $numberCharacter")
        val result = apiDragonBall.getCharacterInfo(numberCharacter)
        Log.d("DragonBallRepository", "getDragonBallInfo result: ${result?.name ?: "null"}")
        return result
    }
}