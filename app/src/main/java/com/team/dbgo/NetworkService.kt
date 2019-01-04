package com.team.dbgo

import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @GET("gym/{gym_id}")
    fun getGymPokemon(
            @Path("gym_id") gym_id : Int
    ) : Call<GymPokemonResponse>

    @GET("users")
    fun getUserInfo(@Query("username") username: String?,
                    @Query("password") password: String?) : Call<UserInfoResponse>

    @GET("users/1/pokemons")
    fun getPokemonInfo() : Call<PokemonInfoResponse>

    @GET("users/1/bag")
    fun getItemInfo() : Call<ItemInfoResponse>

    @GET("pokemon/nearby")
    fun getSurrPoke() : Call<SurrPokeResponse>

    @GET("gym/nearby")
    fun getSurrGym() : Call<SurrGymResponse>

    @GET("pokemon/catch")
    fun getCatchPokemon(@Query("user_id") userId: Int,
                        @Query("pokemon_id") pokemonId: Int) : Call<CatchPokemonResponse>

    @GET("pokemon/evolve")
    fun getEvolvePokemon(@Query("user_id") userId: Int,
                         @Query("pokemon_seq") seq: Int) : Call<EvolvePokemonResponse>
}
