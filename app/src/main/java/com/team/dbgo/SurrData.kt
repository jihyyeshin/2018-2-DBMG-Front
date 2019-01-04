package com.team.dbgo

import com.google.gson.annotations.SerializedName

data class SurrData (
        var pokemon_id : Int,
        var pokemon_name : String,
        @SerializedName("pokemon_seq") val pokemonSeq: Int
)