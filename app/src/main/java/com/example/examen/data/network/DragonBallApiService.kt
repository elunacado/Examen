package com.example.examen.data.network

import com.example.examen.data.network.model.CharacterObject
import retrofit2.http.GET
import retrofit2.http.Query

interface DragonBallApiService {
    @GET("characters")
    suspend fun getCharaters(
        @Query("limit") limit:Int
    ): List<CharacterObject>
}