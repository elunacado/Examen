package com.example.examen.data.network

import android.util.Log
import com.example.examen.data.network.model.DragonBallBase
import com.example.examen.data.network.model.DragonBallObject
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DragonBallApiService {
    @GET("characters")
    suspend fun getCharactersList(
        @Query("limit") limit: Int
    ): DragonBallBase<List<DragonBallObject>>

    @GET("characters/{numberCharacter}")
    suspend fun getCharacterInfo(
        @Path("numberCharacter") numberCharacter: Int
    ): DragonBallObject
}