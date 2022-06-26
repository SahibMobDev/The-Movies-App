package com.example.themoviesapp.screens.favorite

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.themoviesapp.REALIZATION
import com.example.themoviesapp.data.room.repository.MoviesRepositoryRealization
import com.example.themoviesapp.models.MovieItemModel

class FavoriteFragmentViewModel: ViewModel() {


    fun getAllMovies(): LiveData<List<MovieItemModel>> {
        return REALIZATION.allMovies
    }
}