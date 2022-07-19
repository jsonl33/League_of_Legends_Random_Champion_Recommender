package com.example.lolwebcrawlerdice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChampAdapter(var items: ArrayList<ChampItem>) : RecyclerView.Adapter<ChampAdapter.ViewHolder>() {

    //  champ_item.xml과 연결한 뷰 홀더 반환
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampAdapter.ViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.champ_item, parent, false)
        return ViewHolder(itemView)
    }

    // position번째 데이터와 xml 연결
    override fun onBindViewHolder(holder: ChampAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.setItem(item)
    }


    // 아이템 갯수 반환
    override fun getItemCount() = items.count()

    // 데이터와 xml 연결
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun setItem(item: ChampItem) {
            itemView.name.text = item.name
            itemView.portrait.text = item.portrait
            // 이미지 url 읽어서 넣기
            Glide.with(itemView).load(item.portrait).into(itemView.portrait)
        }
    }
}