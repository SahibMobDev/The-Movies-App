package com.example.themoviesapp.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themoviesapp.REALIZATION
import com.example.themoviesapp.data.retrofit.RetrofitRepository
import com.example.themoviesapp.data.room.MoviesRoomDatabase
import com.example.themoviesapp.data.room.repository.MoviesRepositoryRealization
import com.example.themoviesapp.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    val context = application
    fun getMoviesRetrofit() {
        viewModelScope.launch {
            myMovies.value = repository.getMovie()
        }
    }

    fun initDatabase() {
        val daoMovie = MoviesRoomDatabase.getInstance(context).getMovieDao()
        REALIZATION = MoviesRepositoryRealization(daoMovie)

    }


}