// Kotlin
package com.example.examen.data.network.model

data class DragonBallObject(
    override var id: Int,
    override var name: String?,
    override var ki: String?,
    override var maxKi: String?,
    override var race: String?,
    override var gender: String?,
    override var description: String?,
    override var image: String?,
    override var affiliation: String?,
    override var deletedAt: String?
) : DragonBallBase()