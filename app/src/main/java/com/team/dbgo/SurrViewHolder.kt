package com.team.dbgo

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.surr_pokemons.view.*

class SurrViewHolder(itemView : View, val onCatchClicked: (data: SurrData) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val nameView = itemView.surr_pokemon_name
    private val catchButton = itemView.catchButton

    fun loadView(data: SurrData) {
        nameView.text = data.pokemon_name
        catchButton.setOnClickListener {
            onCatchClicked(data)
        }
    }
}