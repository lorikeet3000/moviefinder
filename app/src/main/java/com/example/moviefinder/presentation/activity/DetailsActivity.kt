package com.example.moviefinder.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.moviefinder.presentation.theme.MovieFinderTheme
import com.example.moviefinder.presentation.view.details.DetailsScreen
import com.example.moviefinder.presentation.viewmodel.DetailsViewModel

class DetailsActivity : ComponentActivity() {

    companion object {
        const val MOVIE_ID_KEY = "movie_id"
    }

    private val viewModel by viewModels<DetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieId = intent.extras?.getLong(MOVIE_ID_KEY) ?: 0
        setContent {
            MovieFinderTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DetailsScreen(viewModel)
                }
            }
        }
        viewModel.loadData(movieId)
    }
}