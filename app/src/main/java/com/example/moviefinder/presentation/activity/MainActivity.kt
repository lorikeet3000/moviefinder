package com.example.moviefinder.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.moviefinder.MovieList
import com.example.moviefinder.presentation.theme.MovieFinderTheme
import com.example.moviefinder.presentation.view.main.MovieListScreen
import com.example.moviefinder.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieFinderTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MovieListScreen(viewModel = mainViewModel)
                }
            }
        }
        Log.e("tag", "in MainActivity onCreate")
        mainViewModel.loadMovieList()
    }
}