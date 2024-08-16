package com.example.moviefinder.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.moviefinder.presentation.theme.MovieFinderTheme
import com.example.moviefinder.presentation.view.details.DetailsView

class DetailsActivity : ComponentActivity() {

    companion object {
        const val MOVIE_ID_KEY = "movie_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movieId = intent.extras?.getLong(MOVIE_ID_KEY)
        setContent {
            MovieFinderTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    if (movieId != null) {
                        DetailsView(movieId)
                    } else {
                        Text("Error")
                    }
                }
            }
        }
    }
}