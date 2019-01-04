package com.team.dbgo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.team.dbgo.R.id.parent
import java.text.FieldPosition

class ItemAdapter(var dataList : ArrayList<ItemInfoData>, var requestManager: RequestManager) : RecyclerView.Adapter<ItemViewHolder>() {

    private var onItemClick : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ItemViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.myitems, parent, false)
        return ItemViewHolder(mainView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position:  Int) {
        holder.item_name.text = dataList!!.get(position).item_name
        holder.amount.text = "amount : "+ dataList!!.get(position).amount.toString()
    }

    override fun getItemCount() : Int = dataList!!.size

    fun setOnItemClickListener(l:View.OnClickListener){
        onItemClick = l
    }
}
