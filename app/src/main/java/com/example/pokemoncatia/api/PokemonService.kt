package com.example.pokemoncatia.api

import com.example.pokemoncatia.model.HealthResponse
import com.example.pokemoncatia.model.Pokemon
import com.example.pokemoncatia.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.*

interface PokemonService
{
    @GET("/api/pokemon/health")
    fun checkHealth(): Call<HealthResponse>

    @GET("/api/pokemon")
        fun getPokemons(
        @Query("size") size: String,
        @Query("sort") sort: Int
    ): Call<PokemonResponse>

    @PUT("/api/pokemon")
    fun updatePokemon(
        @Body pokemon: Pokemon
    ) : Call<Pokemon>

    @GET("/api/pokemon/{number}")
    fun getPokemon(
        @Path("number") number: String,
        size: Int
    ) : Call<Pokemon>
}