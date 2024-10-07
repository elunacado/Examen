package com.example.examen.data.network

import com.example.examen.data.network.model.DragonBallObject

class DragonBallApiClient {
    private lateinit var api: DragonBallApiService

    suspend fun getCharactersList(limit:Int): List<DragonBallObject>?{
        api = NetworkModuleDI()
        return try{
            api.getCharactersList(limit)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }

    suspend fun getCharacterInfo(numberCharacter:Int): DragonBallObject?{
        api = NetworkModuleDI()
        return try{
            api.getCharacterInfo(numberCharacter)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }
}