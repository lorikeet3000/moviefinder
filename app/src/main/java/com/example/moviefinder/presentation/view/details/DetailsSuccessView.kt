package com.example.moviefinder.presentation.view.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviefinder.presentation.viewmodel.DetailsViewItem

@Composable
fun DetailsSuccessView(innerPadding: PaddingValues, items: List<DetailsViewItem>) {
    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        items(items) { item ->
            when (item) {
                is DetailsViewItem.Description -> DetailsDescriptionView(item)
                is DetailsViewItem.Image -> DetailsImageView(item)
                is DetailsViewItem.Title -> DetailsTitleView(item)
                is DetailsViewItem.Genres -> DetailsGenreView(item)
                is DetailsViewItem.Countries -> DetailsCountriesView(item)
            }
        }
    }
}

@Composable
fun DetailsCountriesView(item: DetailsViewItem.Countries) {
    val countries = item.countries.joinToString(", ") {
        it.name
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .padding(8.dp)
    ) {
        Text("Страны: ")
        Text(countries)
    }
}

@Composable
fun DetailsGenreView(item: DetailsViewItem.Genres) {
    val genres = item.genres.joinToString(separator = ", ") {
        it.name
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)
            .padding(8.dp)
    ) {
        Text("Жанры: ")
        Text(genres)
    }
}

@Composable
fun DetailsDescriptionView(item: DetailsViewItem.Description) {
    Text(
        text = item.description,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.padding(8.dp)
    )
}

@Composable
fun DetailsImageView(item: DetailsViewItem.Image) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(model = item.imageUrl, contentDescription = null)
    }
}

@Composable
fun DetailsTitleView(item: DetailsViewItem.Title) {
    Text(
        text = item.title,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.headlineLarge,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(8.dp)
    )
}