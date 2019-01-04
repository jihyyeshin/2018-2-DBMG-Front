package com.team.dbgo

data class UserData (
        var user_id : String,
        var trainer_level : Int,
        var user_name : String,
        var password : String,
        var e_mail : String,
        var phone_number : String,
        var birthyear : String,
        var gender : String,
        var pokecoins : Int,
        var exp : Int,
        var exp_to_levelup : Int,
        var max_pokemon_box_capacity : Int,
        var max_egg_bag_capacity : Int,
        var max_bag_capacity : Int,
        var team_code : Int,
        var partner_pokemon : String
)