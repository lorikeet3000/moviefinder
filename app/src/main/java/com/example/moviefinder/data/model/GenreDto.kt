package com.example.moviefinder.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class GenreDto(
    @SerializedName("name")
    val genre: String
)