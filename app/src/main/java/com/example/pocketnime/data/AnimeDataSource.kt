package com.example.pocketnime.data

import com.example.pocketnime.Anime
import com.example.pocketnime.domain.AnimeRepository

class AnimeDataSource : AnimeRepository {
    override fun fetchdata(): List<Anime> {
        return emptyList()
    }

    override fun storedata(anime: Anime) {
        TODO("Not yet implemented")
    }

    override fun savedata(anime: Anime) {
        TODO("Not yet implemented")
    }

    override fun loadAllAnime(): List<Anime> {
        TODO("Not yet implemented")
    }

    override fun delete(anime: Anime) {
        TODO("Not yet implemented")
    }

    override fun loadAnimeByid(id: Int): Anime {
        TODO("Not yet implemented")
    }
}