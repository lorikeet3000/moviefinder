package com.example.moviefinder.presentation.view.main

import android.content.Context
import android.content.Intent
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.moviefinder.presentation.activity.DetailsActivity
import com.example.moviefinder.presentation.model.Movie
import com.example.moviefinder.presentation.theme.MovieFinderTheme
import com.example.moviefinder.presentation.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(viewModel: MainViewModel) {
    val context = LocalContext.current
    val moviesList = viewModel.movieList.observeAsState()
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
                items(moviesList.value ?: emptyList()) { movie ->
                    MovieItemView(movie = movie) {
                        onItemClicked(context, it)
                    }
                }
            }
        }
    }
}

private fun onItemClicked(context: Context, item: Movie) {
    val intent = Intent(context, DetailsActivity::class.java)
    intent.putExtra(DetailsActivity.MOVIE_ID_KEY, item.id)
    context.startActivity(intent)
}