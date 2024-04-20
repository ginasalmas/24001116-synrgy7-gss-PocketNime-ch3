package com.example.pocketnime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

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

        anime?.let {
            dataTitle.text = it.animeTitle
            dataPoster.setImageResource(it.animePoster)
        }

        return view
    }
}
