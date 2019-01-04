package com.team.dbgo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class GymViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!) {
    var gym_pokemon_name : TextView = itemView!!.findViewById(R.id.gym_pokemon_name) as TextView
    var gym_pokemon_cp : TextView = itemView!!.findViewById(R.id.gym_pokemon_cp) as TextView
}