package com.example.randomjokeapp.data.network

import com.example.randomjokeapp.domain.models.JokesModel
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("random_joke")
    suspend fun getJoke():JokesModel
}