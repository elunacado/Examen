package com.example.examen.domain

import com.example.examen.data.DragonBallRepository
import com.example.examen.data.network.model.DragonBallObject

class DragonBallInfoRequirements {
    private val repository = DragonBallRepository()

    suspend operator fun invoke(
        id: Int
    ): DragonBallObject? = repository.getDragonBallInfo(id)
}