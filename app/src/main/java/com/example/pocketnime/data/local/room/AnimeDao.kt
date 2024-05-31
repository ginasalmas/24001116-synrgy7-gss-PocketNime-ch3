package com.example.pocketnime.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimeDao {
    @Insert
    fun insertAnime(animeEntity: AnimeEntity)

    @Delete
    fun deleteAnime(animeEntity: AnimeEntity)

    @Query("Select * from anime_table where id = :id")
    fun selectAnimeById(id: Int): AnimeEntity

    @Query("Select * from anime_table")
    fun selectAllAnime(): List<AnimeEntity>

}