package com.example.examen.data

import com.example.examen.data.network.DragonBallApiClient
import com.example.examen.data.network.model.DragonBallObject

class DragonBallRepository {
    private val apiDragonBall = DragonBallApiClient()

    suspend fun getDragonBallList(limit: Int): List<DragonBallObject>? = apiDragonBall.getCharactersList(limit)
    suspend fun getDragonBallInfo(numberCharacter: Int): DragonBallObject? = apiDragonBall.getCharacterInfo(numberCharacter)

}