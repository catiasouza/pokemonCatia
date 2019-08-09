package com.example.pokemoncatia.view.flash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemoncatia.repository.PokemonRepository


class SplashViewModel(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    val messageError = MutableLiveData<String>()

    fun checkHealth() {
        pokemonRepository.checkHealth(
            onComplete = {
                messageError.value = ""
            }, onError = {
                messageError.value = it.message
            })
    }
}