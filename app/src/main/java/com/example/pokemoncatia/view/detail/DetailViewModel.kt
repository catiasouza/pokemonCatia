package com.example.pokemoncatia.view.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemoncatia.model.Pokemon
import com.example.pokemoncatia.repository.PokemonRepository


class DetailViewModel(
    val pokemonRepository: PokemonRepository
    ) : ViewModel() {

        val isLoading = MutableLiveData<Boolean>()
        val pokemon = MutableLiveData<Pokemon>()
        fun getPokemon(number: String) {

            pokemonRepository.getPokemon(
                    number,
                onComplete = {
                isLoading.value = false
                pokemon.value = it
                },
            onError = { isLoading.value = false
            }
            )
        } }

