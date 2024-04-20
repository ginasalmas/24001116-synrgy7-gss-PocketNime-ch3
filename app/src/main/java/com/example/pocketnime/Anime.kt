package com.example.pocketnime

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val animeTitle: String,
    val animePoster: Int,
    val animeLink: String,
    val animeSynopsis: String
):Parcelable
