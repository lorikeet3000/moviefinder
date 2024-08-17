package com.example.moviefinder.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

sealed class DetailsUiState {

    data class Success(val items: List<DetailsViewItem>) : DetailsUiState()
    data object Loading : DetailsUiState()
    data class Error(val message: String) : DetailsUiState()
}

sealed class DetailsViewItem {
    data class Image(val imageUrl: String)
    data class Title(val title: String)
    data class Description(val description: String)
}

class DetailsViewModel : ViewModel() {

    private val _detailsUiState = MutableLiveData<DetailsUiState>()
    val detailsUiState: LiveData<DetailsUiState> = _detailsUiState

    fun loadData(id: Long) {
        viewModelScope.launch {
            _detailsUiState.value = DetailsUiState.Loading

            delay(2000)

            _detailsUiState.value = try {
                DetailsUiState.Success(emptyList())
            } catch (e: Exception) {
                DetailsUiState.Error("Something went wrong")
            }

        }
    }
}