package com.team.dbgo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class ItemViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!) {
    var item_name : TextView = itemView!!.findViewById(R.id.item_name) as TextView
    var amount:TextView = itemView!!.findViewById(R.id.amount) as TextView
}