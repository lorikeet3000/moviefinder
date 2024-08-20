package com.example.moviefinder.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviefinder.data.repository.MovieFinderRepository
import com.example.moviefinder.presentation.mapper.MovieFinderMapper
import com.example.moviefinder.presentation.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieFinderRepository,
    private val mapper: MovieFinderMapper,
) : ViewModel() {

    private val _movieListLiveData: MutableLiveData<List<Movie>> = MutableLiveData(emptyList())
    val movieList: LiveData<List<Movie>> = _movieListLiveData

    fun loadMovieList() {
        viewModelScope.launch {
            try {
                val response = repository.getMovieList()
                _movieListLiveData.value = mapper.mapMovieList(response)
            } catch (ioException: IOException) {
                Log.e("tag", "error " + ioException)
            } catch (exception: Exception) {
                Log.e("tag", "exception " + exception)
            }
        }
    }
}