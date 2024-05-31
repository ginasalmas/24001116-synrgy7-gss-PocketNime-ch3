package com.example.pocketnime.domain

import com.example.pocketnime.Anime

interface AnimeRepository {
    fun fetchdata(): List<Anime>
    fun storedata(anime: Anime)
    fun savedata(anime: Anime)
    fun loadAllAnime(): List<Anime>
    fun delete(anime: Anime)
    fun loadAnimeByid(id: Int): Anime
}