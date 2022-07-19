package com.example.lolwebcrawlerdice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.champ_item.view.*

/**
 * 현재 불가피하게 kotlinx 플러그인 사용하였으니
 * 추후에 findViewById 메소드로 Refactor 요망
 */

class ChampAdapter(var items: ArrayList<ChampItem>) : RecyclerView.Adapter<ChampAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampAdapter.ViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.champ_item, parent, false)
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
            Glide.with(itemView).load(item.portrait).into(itemView.portrait)
        }
    }
}