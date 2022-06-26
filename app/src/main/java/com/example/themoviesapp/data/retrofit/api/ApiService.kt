package com.example.themoviesapp.data.retrofit.api

import com.example.themoviesapp.models.MoviesModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("3/movie/popular?api_key=a036dc05c534b0cd90d6e8a8e2bcf871&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<MoviesModel>
}