package com.team.dbgo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 아이템 클릭 리스너
 */
fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}



class SurrAdapter(val onItemClicked: (data: SurrData) -> Unit,
                  private val onCatchClicked: (data: SurrData) -> Unit) : RecyclerView.Adapter<SurrViewHolder>() {

    private var dataList = emptyList<SurrData>()

    fun reloadData(newDataList: List<SurrData>) {
        dataList = newDataList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): SurrViewHolder {
        val mainView: View = LayoutInflater.from(parent.context).inflate(R.layout.surr_pokemons, parent, false)
        return SurrViewHolder(mainView, onCatchClicked).listen { position, _ ->
            onItemClicked(dataList[position])
        }
    }

    override fun onBindViewHolder(holder: SurrViewHolder, position: Int) {
        holder.loadView(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}