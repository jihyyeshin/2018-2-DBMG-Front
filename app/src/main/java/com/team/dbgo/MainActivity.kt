package com.team.dbgo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.activity_surrounding.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var gymDatas: ArrayList<GymPokemonResponse>? = null

    private val adapter1 by lazy {
        SurrAdapter({ data ->
            Toast.makeText(this, data.pokemon_name, Toast.LENGTH_SHORT).show()
        }, { data ->
            networkService?.getCatchPokemon(1, data.pokemon_id)
                    ?.enqueue(object : Callback<CatchPokemonResponse> {
                        override fun onFailure(call: Call<CatchPokemonResponse>?, t: Throwable?) {
                            ApplicationController.instance?.makeToast("통신 확인")
                        }

                        override fun onResponse(call: Call<CatchPokemonResponse>?, response: Response<CatchPokemonResponse>?) {
                            response?.let {
                                if (it.isSuccessful) {
                                    ApplicationController.instance?.makeToast(it.body().message)
                                }
                            }
                        }
                    })
        })
    }
    private val adapter2 by lazy {
        SurrGymAdapter { data ->
            Toast.makeText(this,  data.title, Toast.LENGTH_SHORT).show()
        }
    }

    private var networkService: NetworkService? = null
    private var requestManager: RequestManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surrounding)

        surr_pokemon_list.layoutManager = LinearLayoutManager(this)
        surr_pokemon_list.adapter = adapter1

        networkService = ApplicationController.instance!!.networkService
        requestManager = Glide.with(this)

        networkService!!.getSurrPoke()
                .enqueue(object : retrofit2.Callback<SurrPokeResponse> {
                    override fun onFailure(call: Call<SurrPokeResponse>?, t: Throwable?) {
                        ApplicationController.instance!!.makeToast("통신 확인")
                    }

                    override fun onResponse(call: Call<SurrPokeResponse>?, response: Response<SurrPokeResponse>?) {
                        response?.let {
                            if (it.isSuccessful) {
                                adapter1.reloadData(it.body().pokemons)
                            }
                        }
                    }
                })

        surr_gym_list.layoutManager = LinearLayoutManager(this)
        surr_gym_list.adapter = adapter2

        val getSurrGymResponse = networkService!!.getSurrGym()
        getSurrGymResponse.enqueue(object : retrofit2.Callback<SurrGymResponse> {
            override fun onFailure(call: Call<SurrGymResponse>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 확인")
            }

            override fun onResponse(call: Call<SurrGymResponse>?, response: Response<SurrGymResponse>?) {
                response?.let {
                    if (it.isSuccessful) {
                        adapter2.reloadData(it.body().gyms)
                    }
                }
            }

        })
        go_to_mypage.setOnClickListener {
            val intent = Intent(this, MypageActivity::class.java)
            startActivity(intent)
        }

    }
}
