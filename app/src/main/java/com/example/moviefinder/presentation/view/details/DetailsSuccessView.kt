package com.example.moviefinder.presentation.view.details

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.moviefinder.presentation.viewmodel.DetailsViewItem

@Composable
fun DetailsSuccessView(innerPadding: PaddingValues, items: List<DetailsViewItem>) {
    LazyColumn(modifier = Modifier.padding(innerPadding)) {
        items(items) { item ->
            when(item) {
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
    Row {
        Text("Страны: ")
        Text(countries)
    }
}

@Composable
fun DetailsGenreView(item: DetailsViewItem.Genres) {
    val genres = item.genres.joinToString(separator = ", ") {
        it.name
    }
    Row {
       Text("Жанры: ")
       Text(genres)
    }
}

@Composable
fun DetailsDescriptionView(item: DetailsViewItem.Description) {
    Text(text = item.description)
}

@Composable
fun DetailsImageView(item: DetailsViewItem.Image) {
    AsyncImage(model = item.imageUrl, contentDescription = null)
}

@Composable
fun DetailsTitleView(item: DetailsViewItem.Title) {
    Text(text = item.title)
}