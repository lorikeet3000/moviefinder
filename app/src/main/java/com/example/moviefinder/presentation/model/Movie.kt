package com.example.moviefinder.presentation.model

data class Movie(
    val id: Long,
    val title: String,
    val description: String,
    val rating: Double,
    val imageUrl: String,
    val year: Int,
)