package com.team.dbgo

import android.content.Context
import android.content.SyncRequest
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.team.dbgo.R.id.parent
import java.text.FieldPosition

class GymAdapter(var dataList : ArrayList<GymData>, var requestManager: RequestManager) : RecyclerView.Adapter<GymViewHolder>() {

    private var onItemClick : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GymViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.gym_pokemons, parent, false)
        return GymViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: GymViewHolder, position:  Int) {
        holder.gym_pokemon_name.text = dataList!!.get(position).pokemon_name
        holder.gym_pokemon_cp.text = "cp : "+ dataList!!.get(position).combat_point.toString()
    }

    override fun getItemCount() : Int = dataList!!.size

    fun setOnItemClickListener(l:View.OnClickListener){
        onItemClick = l
    }
}
