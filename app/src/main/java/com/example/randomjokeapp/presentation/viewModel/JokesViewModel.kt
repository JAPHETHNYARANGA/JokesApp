package com.example.randomjokeapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomjokeapp.domain.models.JokesModel
import com.example.randomjokeapp.domain.useCases.GetJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class JokesViewModel @Inject constructor(private val getJokesUseCase: GetJokesUseCase) : ViewModel() {
    private val _joke = MutableStateFlow(JokesModel())
    val joke: StateFlow<JokesModel> get() = _joke

    init {
        fetchJoke()
    }

     fun fetchJoke() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val joke = getJokesUseCase.getJoke()
                _joke.value = joke
                Log.d("Success", joke.toString())
            } catch (e: Exception) {
                Log.d("Failure", e.message ?: "Unknown error occurred")
            }
        }
    }
}