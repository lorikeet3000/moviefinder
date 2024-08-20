package com.example.moviefinder.data.model

import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("kp")
    val kpRating: Double
)