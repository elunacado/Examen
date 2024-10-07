package com.example.examen.data.network.model

import com.google.gson.annotations.SerializedName

data class DragonBallBase<T>(
    @SerializedName("items") val items: T,
    @SerializedName("meta") val meta: Meta,
    @SerializedName("links") val links: Links
)

data class Meta(
    @SerializedName("totalItems") val totalItems: Int,
    @SerializedName("itemCount") val itemCount: Int,
    @SerializedName("itemsPerPage") val itemsPerPage: Int,
    @SerializedName("totalPages") val totalPages: Int,
    @SerializedName("currentPage") val currentPage: Int
)

data class Links(
    @SerializedName("first") val first: String,
    @SerializedName("previous") val previous: String?,
    @SerializedName("next") val next: String?,
    @SerializedName("last") val last: String
)