package com.example.themoviesapp.data.retrofit

import com.example.themoviesapp.data.retrofit.api.ApiService
import com.example.themoviesapp.data.retrofit.api.RetrofitInstance
import com.example.themoviesapp.models.MoviesModel
import retrofit2.Response

class RetrofitRepository {

    suspend fun getMovie(): Response<MoviesModel> {
        return RetrofitInstance.api.getPopularMovie()
    }

}