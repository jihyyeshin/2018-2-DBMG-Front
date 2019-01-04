package com.team.dbgo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonDetailActivity : AppCompatActivity() {


    private var networkService: NetworkService? = null
    private var requestManager: RequestManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        networkService = ApplicationController.instance!!.networkService
        requestManager = Glide.with(this)

        val getPokemonInfoResponse =networkService!!.getPokemonInfo()
        getPokemonInfoResponse.enqueue(object :Callback<PokemonInfoResponse>{
            override fun onResponse(call: Call<PokemonInfoResponse>?, response: Response<PokemonInfoResponse>?) {
                if(response!!.isSuccessful){
                    if(response!!.body().pokemons != null){
                        val name:String = intent.getStringExtra("name")
                        val height:String = intent.getStringExtra("height")+" m"
                        val weight:String = intent.getStringExtra("weight")+" kg"
                        var cp:String= intent.getStringExtra("cp")
                        val catched_at:String = intent.getStringExtra("catched_at")

                        detail_name.text=name
                        detail_height.text=height
                        detail_weight.text=weight
                        detail_cp.text=cp
                        detail_date.text=catched_at
                    }
                }
            }
            override fun onFailure(call: Call<PokemonInfoResponse>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 확인")
            }

        })

    }
}