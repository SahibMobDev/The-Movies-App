package com.example.themoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.themoviesapp.models.MovieItemModel

interface MoviesRepository {

    val allMovies: LiveData<List<MovieItemModel>>

    suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess:() -> Unit)

    suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit)


}