package com.example.moviefinder.presentation.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviefinder.MovieList
import com.example.moviefinder.presentation.model.Movie
import com.example.moviefinder.presentation.theme.MovieFinderTheme

@Composable
fun MovieListView(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItemView(movie = movie)
        }
    }
}

@Preview
@Composable
fun MovieListPreview() {
    MovieFinderTheme {
        MovieListView(MovieList)
    }
}