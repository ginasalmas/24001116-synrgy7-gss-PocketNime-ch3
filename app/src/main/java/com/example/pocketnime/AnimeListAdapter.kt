package com.example.pocketnime

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeListAdapter(private val context: Context, private val listAnime: ArrayList<Anime>, private val onItemClick: (Anime) -> Unit) :
    RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime_card, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val (animeTitle, animePoster) = listAnime[position]
        holder.tvTitle.text = animeTitle
        holder.ivPoster.setImageResource(animePoster)
        holder.itemView.tag = listAnime[position]

        holder.itemView.setOnClickListener {
            onItemClick.invoke(listAnime[position])
        }
    }

    override fun getItemCount(): Int = listAnime.size

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val ivPoster: ImageView = itemView.findViewById(R.id.ivPoster)
    }
}