package com.example.themoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.example.themoviesapp.data.room.dao.MoviesDao
import com.example.themoviesapp.models.MovieItemModel

class MoviesRepositoryRealization(private val moviesDao: MoviesDao): MoviesRepository{
    override val allMovies: LiveData<List<MovieItemModel>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.insert(movieItemModel)
        onSuccess()
    }

    override suspend fun deleteMovie(movieItemModel: MovieItemModel, onSuccess: () -> Unit) {
        moviesDao.delete(movieItemModel)
        onSuccess()
    }

}