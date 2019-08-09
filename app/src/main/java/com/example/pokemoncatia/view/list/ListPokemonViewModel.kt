package com.example.pokemoncatia.view.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemoncatia.model.Pokemon
import com.example.pokemoncatia.repository.PokemonRepository

class ListPokemonsViewModel(val pokemonRepository: PokemonRepository) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val pokemons = MutableLiveData<List<Pokemon>>()
    val messageError = MutableLiveData<String>()

    fun getPokemons() {
        isLoading.value = true
        pokemonRepository.getPokemons(
            sort = "number,asc",
            size = 150,
            onComplete = {
                isLoading.value = false
                pokemons.value = it
                messageError.value = ""
            },
            onError = {
                isLoading.value = false
                pokemons.value = listOf()
                messageError.value = it.message

            }
        )


    }

}