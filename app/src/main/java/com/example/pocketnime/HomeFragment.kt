package com.example.pocketnime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager

class HomeFragment : Fragment() {

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var animeAdapter: AnimeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize the adapter with sample data
        val categories = mutableListOf<Category>()
        val dataNames = resources.getStringArray(R.array.data_name)
        val dataPhotos = resources.obtainTypedArray(R.array.data_photo)

        for (i in dataNames.indices) {
            categories.add(Category(dataNames[i], dataPhotos.getResourceId(i, 0)))
        }
        dataPhotos.recycle()

        categoryAdapter = CategoryAdapter(categories, ::onCategoryClicked)

        view.findViewById<RecyclerView>(R.id.rvCategory).adapter = categoryAdapter
        view.findViewById<RecyclerView>(R.id.rvCategory).layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        // Initialize the anime adapter with sample data
        val animes = mutableListOf<Anime>()
        val animeTitles = resources.getStringArray(R.array.data_anime_title)
        val animePosters = resources.obtainTypedArray(R.array.data_anime_poster)
        val animeLinks = resources.getStringArray(R.array.data_anime_link)

        for (i in animeTitles.indices) {
            animes.add(Anime(animeTitles[i], animePosters.getResourceId(i, 0), animeLinks[i]))
        }
        animePosters.recycle()

        animeAdapter = AnimeListAdapter(animes, ::onAnimeClicked)

        view.findViewById<RecyclerView>(R.id.rvAnimeList).adapter = animeAdapter
        view.findViewById<RecyclerView>(R.id.rvAnimeList).layoutManager = GridLayoutManager(requireContext(), 3)

        return view
    }

    private fun onCategoryClicked(category: Category) {
        // Handle category click event
        Toast.makeText(requireContext(), "Clicked: ${category.title}", Toast.LENGTH_SHORT).show()
    }

    private fun onAnimeClicked(anime: Anime) {
        // Handle anime click event
        Toast.makeText(requireContext(), "Clicked: ${anime.animeTitle}", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}