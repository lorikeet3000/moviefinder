package com.example.moviefinder.data.model

import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("name")
    val country: String
)