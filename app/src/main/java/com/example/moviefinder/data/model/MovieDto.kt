package com.example.moviefinder.data.model

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val title: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("rating")
    val rating: RatingDto,
    @SerializedName("poster")
    val image: ImageDto,
    @SerializedName("genres")
    val genres: List<GenreDto>,
    @SerializedName("countries")
    val countries: List<CountryDto>
)