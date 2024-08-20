package com.example.moviefinder.data.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("docs")
    val movies: List<MovieDto>,
    @SerializedName("total")
    val total: Long
)