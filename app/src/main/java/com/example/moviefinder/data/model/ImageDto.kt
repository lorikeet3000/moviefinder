package com.example.moviefinder.data.model

import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("previewUrl")
    val imageUrl: String
)