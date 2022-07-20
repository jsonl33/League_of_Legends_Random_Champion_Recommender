package com.example.lolwebcrawlerdice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.champ_item.view.*

class ChampAdapter(var items: ArrayList<ChampItem>) : RecyclerView.Adapter<ChampAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.champ_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChampAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }

    override fun getItemCount() = items.count()

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun setItem(item: ChampItem) {
            itemView.name.text = item.name
            // 이미지 url 읽어서 넣기
            GlideApp.with(itemView)
             .load(item.portrait)
             .into(itemView.portrait)
        }
    }
}