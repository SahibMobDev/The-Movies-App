package com.example.themoviesapp.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviesapp.REALIZATION
import com.example.themoviesapp.data.room.repository.MoviesRepositoryRealization
import com.example.themoviesapp.models.MovieItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {


    fun insert(movieItemModel: MovieItemModel, onSuccess:() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.insertMovie(movieItemModel) {
                onSuccess()
            }
        }
    }

    fun delete(movieItemModel: MovieItemModel, onSuccess:() -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.deleteMovie(movieItemModel) {
                onSuccess()
            }
        }
    }
}