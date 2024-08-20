package com.example.moviefinder.data.service

import com.example.moviefinder.data.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieFinderService {

    @Headers("X-API-KEY: EVMPC8E-3FP4DJT-G7H2184-SRCK3T1")
    @GET("/v1.4/movie?page=1&limit=15&rating.kp=7.5-10&votes.kp=20000-1000000")
    suspend fun getMovieList(): MovieListResponse
}