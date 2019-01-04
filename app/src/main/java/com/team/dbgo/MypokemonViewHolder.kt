package com.team.dbgo

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.my_pokenmons.view.*

class MypokemonViewHolder(itemView : View, val onEvolveClicked: (data: MypokemonData) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val nameView = itemView.name
    private val evolveButton = itemView.evolveButton

    fun loadView(data: MypokemonData) {
        nameView.text = data.name
        evolveButton.setOnClickListener {
            onEvolveClicked(data)
        }
    }
}