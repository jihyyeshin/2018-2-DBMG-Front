package com.team.dbgo

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager

class MypokemonAdapter(var requestManager: RequestManager,val onClicked: (position: Int) -> Unit, private val onEvolveClicked: (data:MypokemonData)->Unit) : RecyclerView.Adapter<MypokemonViewHolder>() {

    private var dataList = emptyList<MypokemonData>()


    fun reloadData(newDataList: List<MypokemonData>) {
        dataList = newDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MypokemonViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.my_pokenmons, parent, false)
        return MypokemonViewHolder(mainView, onEvolveClicked).listen { position, _ ->
            Log.d("adsf", "$position")
            onClicked(position)
        }
    }

    override fun onBindViewHolder(holder: MypokemonViewHolder, position:  Int) {
        holder.loadView(dataList[position])
        //.text = dataList!!.get(position).name
    }

    override fun getItemCount() : Int = dataList!!.size
}