package com.example.moviefinder.data.repository

import com.example.moviefinder.data.model.MovieListResponse
import com.example.moviefinder.data.service.MovieFinderService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieFinderRepository @Inject constructor(
    private val service: MovieFinderService
) {

    suspend fun getMovieList(): MovieListResponse {
        return withContext(Dispatchers.IO) {
            service.getMovieList()
        }
    }
}