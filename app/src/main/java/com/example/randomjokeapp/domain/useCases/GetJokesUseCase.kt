package com.example.randomjokeapp.domain.useCases

import com.example.randomjokeapp.data.repositories.GetJokeRepository
import com.example.randomjokeapp.domain.models.JokesModel
import javax.inject.Inject

class GetJokesUseCase @Inject constructor(private val getJokeRepository: GetJokeRepository) {
    suspend fun getJoke(): JokesModel{
        return getJokeRepository.getJokes()
    }
}