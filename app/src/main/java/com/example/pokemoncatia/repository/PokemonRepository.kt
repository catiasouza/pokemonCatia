package com.example.pokemoncatia.repository

import com.example.pokemoncatia.model.Pokemon

interface PokemonRepository {

    fun checkHealth(
        onComplete:() -> Unit,
        onError:(t: Throwable) -> Unit
    )

    fun getPokemons(
        sort: String,
        size: Int,
        onComplete:(List<Pokemon>) -> Unit,
        onError:(Throwable) -> Unit
    )

    fun updatePokemon(
        pokemon: Pokemon,
        onComplete:(Pokemon?) -> Unit,
        onError:(Throwable) -> Unit
    )
    fun getPokemon(
    number: String, onComplete:(Pokemon?) -> Unit, onError:(Throwable) -> Unit
    )

}