package com.example.pocketnime.data.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime_table")
data class AnimeEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "title")
    val animeTitle: String,

    @ColumnInfo(name = "poster")
    val animePoster: Int,

    @ColumnInfo(name = "link")
    val animeLink: String,

    @ColumnInfo(name = "synopsis")
    val animeSynopsis: String
)
