package com.example.moviefinder.presentation.mapper

import com.example.moviefinder.data.model.MovieListResponse
import com.example.moviefinder.presentation.model.Movie
import javax.inject.Inject

class MovieFinderMapper @Inject constructor() {

    fun mapMovieList(movieList: MovieListResponse): List<Movie> {
        return movieList.movies.map { dto ->
            Movie(
                id = dto.id,
                title = dto.title,
                description = dto.description,
                rating = dto.rating.kpRating,
                imageUrl = dto.image.imageUrl,
                year = dto.year
            )
        }
    }
}