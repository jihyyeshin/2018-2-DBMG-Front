package com.team.dbgo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class SurrGymViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView!!) {
    var title : TextView = itemView!!.findViewById(R.id.surr_gym_name) as TextView
}