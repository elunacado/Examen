package com.example.examen.domain

import android.util.Log
import com.example.examen.data.DragonBallRepository
import com.example.examen.data.network.model.DragonBallObject

class DragonBallListRequirements {
    private val repository = DragonBallRepository()

    suspend operator fun invoke(
        limit: Int
    ): List<DragonBallObject>? {
        Log.d("DragonBallListRequirements", "Fetching DragonBall list with limit: $limit")
        val result = repository.getDragonBallList(limit)
        Log.d("DragonBallListRequirements", "Fetched ${result?.size ?: 0} DragonBall objects")
        return result
    }
}