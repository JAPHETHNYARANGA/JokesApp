package com.example.randomjokeapp.data.repositories

import com.example.randomjokeapp.data.network.RetrofitInterface
import com.example.randomjokeapp.domain.models.JokesModel
import javax.inject.Inject

class GetJokeRepository @Inject constructor(private val retrofitInterface: RetrofitInterface) {
    suspend fun getJokes():JokesModel{
        return retrofitInterface.getJoke()
    }
}