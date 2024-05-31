package com.example.pocketnime.data.remote

import com.example.pocketnime.Anime

interface AnimeRemoteDataSource {
    fun fetchData(): List<Anime>
}