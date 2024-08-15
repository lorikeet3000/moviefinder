package com.example.moviefinder.presentation.view

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.moviefinder.MovieList
import com.example.moviefinder.presentation.model.Movie
import com.example.moviefinder.presentation.theme.MovieFinderTheme

@Composable
fun MovieItemView(movie: Movie) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        AsyncImage(
            model = movie.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clickable {
                    onItemClicked(movie)
                }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = movie.title,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.clickable {
                    onItemClicked(movie)
                }
            )
            Text(
                text = "${movie.rating}",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            var isExpanded by remember { mutableStateOf(false) }
            Text(
                text = movie.description,
                modifier = Modifier
                    .padding(all = 4.dp)
                    .clickable {
                        isExpanded = !isExpanded
                    },
                style = MaterialTheme.typography.bodySmall,
                maxLines = if (isExpanded) Int.MAX_VALUE else 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

private fun onItemClicked(item: Movie) {
    Log.e("tag", "click ${item.title} ${item.id}")
    // todo show details screen
}

@Preview(showBackground = true, name = "Light mode")
@Composable
fun MovieItemPreview() {
    MovieFinderTheme {
        Surface {
            MovieItemView(MovieList[0])
        }
    }
}