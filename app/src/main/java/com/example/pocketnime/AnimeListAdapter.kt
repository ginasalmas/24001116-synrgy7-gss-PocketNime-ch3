package com.example.pocketnime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeListAdapter(private val animes: List<Anime>, private val onItemClick: (Anime) -> Unit) :
    RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animePoster: ImageView = itemView.findViewById(R.id.ivPoster)
        val animeTitle: TextView = itemView.findViewById(R.id.tvTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_anime_card, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animes[position]
        holder.animePoster.setImageResource(anime.animePoster)
        holder.animeTitle.text = anime.animeTitle
        holder.itemView.setOnClickListener { onItemClick(anime) }
    }

    override fun getItemCount(): Int = animes.size
}