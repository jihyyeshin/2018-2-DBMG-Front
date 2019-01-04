package com.team.dbgo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class GymActivity : AppCompatActivity(), View.OnClickListener {


    private var pokemonList : RecyclerView? = null
    private var pokemonDatas : ArrayList<GymData>? = null
    private var adapter : GymAdapter? = null


    private var networkService: NetworkService? = null
    private var requestManager: RequestManager? = null


    override fun onClick(v: View?) {

        val idx : Int = pokemonList!!.getChildAdapterPosition(v!!)

        val name : String? = pokemonDatas!!.get(idx).pokemon_name
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()

    }

    var gym_id : Int ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym)


        networkService = ApplicationController.instance!!.networkService
        requestManager = Glide.with(this)

        pokemonList = findViewById(R.id.gym_pokemon_list) as RecyclerView
        pokemonList!!.layoutManager = LinearLayoutManager(this)
        gym_id = intent.getIntExtra("gym_id", 3)

        val getGymPokemonResponse = networkService!!.getGymPokemon(gym_id!!)
        getGymPokemonResponse.enqueue(object : retrofit2.Callback<GymPokemonResponse>{
            override fun onFailure(call: Call<GymPokemonResponse>?, t: Throwable?) {
                ApplicationController.instance!!.makeToast("통신 확인")
            }

            override fun onResponse(call: Call<GymPokemonResponse>?, response: Response<GymPokemonResponse>?) {
                if(response!!.isSuccessful){
                    if(response!!.body().results != null){

                        adapter = GymAdapter(response!!.body().results, requestManager!!)
                        pokemonDatas = response!!.body().results
                        pokemonList!!.adapter = adapter
                    }
                }
            }

        })

    }
}
