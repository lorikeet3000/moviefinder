package com.example.moviefinder.presentation.view.details

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.moviefinder.presentation.viewmodel.DetailsUiState
import com.example.moviefinder.presentation.viewmodel.DetailsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(viewModel: DetailsViewModel) {
    val uiState by viewModel.detailsUiState.observeAsState()
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
        when(val state = uiState) {
            is DetailsUiState.Error -> DetailsErrorView(innerPadding)
            DetailsUiState.Loading -> DetailsLoadingView(innerPadding)
            is DetailsUiState.Success -> DetailsSuccessView(innerPadding, state.items)
            null -> {}
        }
    }
}

@Composable
fun DetailsErrorView(innerPadding: PaddingValues) {
    Text(text = "error", modifier = Modifier.padding(innerPadding))
}

@Composable
fun DetailsLoadingView(innerPadding: PaddingValues) {
    CircularProgressIndicator(modifier = Modifier.padding(innerPadding))
}