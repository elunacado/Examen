package com.example.examen.domain

import com.example.examen.data.DragonBallRepository
import com.example.examen.data.network.model.DragonBallObject

class DragonBallListRequirements {
    private val repository = DragonBallRepository()

    suspend operator fun invoke(
        limit: Int
    ): List<DragonBallObject>? = repository.getDragonBallList(limit)
}