package com.example.pocketnime.data.local.room

import androidx.room.Database

@Database(
    entities = [
        AnimeEntity::class,
    ],
    version = 1,
)
abstract class RoomDatabase {
    abstract fun animeDao(): AnimeDao

}