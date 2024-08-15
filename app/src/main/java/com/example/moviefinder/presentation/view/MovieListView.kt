package com.example.moviefinder.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviefinder.MovieList
import com.example.moviefinder.presentation.model.Movie
import com.example.moviefinder.presentation.theme.MovieFinderTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListView(movies: List<Movie>) {
    MovieFinderTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("MovieFinder")
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(movies) { movie ->
                    MovieItemView(movie = movie)
                }
            }
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