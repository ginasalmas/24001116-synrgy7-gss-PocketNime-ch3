package com.example.pocketnime

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val anime = requireArguments().getParcelable<Anime>(HomeFragment.INTENT_PARCELABLE)

        val dataTitle: TextView = view.findViewById(R.id.tvDetailTitle)
        val dataPoster: ImageView = view.findViewById(R.id.ivDetailPoster)
        val dataSynopsis: TextView = view.findViewById(R.id.tvDetailSynopsis)
        val btnMore = view.findViewById<MaterialButton>(R.id.btnMore)
        btnMore.tag = anime
        btnMore.setOnClickListener {
            moreAnime(anime?.animeLink)
        }

        anime?.let {
            dataTitle.text = it.animeTitle
            dataPoster.setImageResource(it.animePoster)
            dataSynopsis.text = it.animeSynopsis
        }

        return view
    }

    private fun moreAnime(link: String?) {
        link?.let {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(link)
            startActivity(intent)
        }
    }
}
