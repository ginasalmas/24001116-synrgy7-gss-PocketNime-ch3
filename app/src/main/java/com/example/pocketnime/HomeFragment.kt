package com.example.pocketnime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var animeAdapter: AnimeListAdapter
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        rvAnime = view.findViewById(R.id.rvAnimeList)
        rvAnime.setHasFixedSize(true)
        list.addAll(getListAnime())
        showRecyclerList()

        // Initialize the adapter with sample data
        val categories = mutableListOf<Category>()
        val dataNames = resources.getStringArray(R.array.data_name)
        val dataPhotos = resources.obtainTypedArray(R.array.data_photo)

        for (i in dataNames.indices) {
            categories.add(Category(dataNames[i], dataPhotos.getResourceId(i, 0)))
        }
        dataPhotos.recycle()

        val categoryAdapter = CategoryAdapter(categories) { category ->
            onCategoryClicked(category)
        }

        view.findViewById<RecyclerView>(R.id.rvCategory).adapter = categoryAdapter
        view.findViewById<RecyclerView>(R.id.rvCategory).layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return view
    }

    private fun getListAnime(): ArrayList<Anime> {
        val dataTitles = resources.getStringArray(R.array.data_anime_title)
        val dataPosters = resources.obtainTypedArray(R.array.data_anime_poster)
        val dataLinks = resources.getStringArray(R.array.data_anime_link)
        val dataSynopses = resources.getStringArray(R.array.data_anime_synopsis)

        val listAnime = ArrayList<Anime>()
        for (i in dataTitles.indices) {
            val anime = Anime(dataTitles[i], dataPosters.getResourceId(i, -1), dataLinks[i], dataSynopses[i])
            listAnime.add(anime)
        }

        dataPosters.recycle()
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnime.layoutManager = GridLayoutManager(requireContext(), 3)
        animeAdapter = AnimeListAdapter(requireContext(), list) { anime ->
            val bundle = Bundle()
            bundle.putParcelable(HomeFragment.INTENT_PARCELABLE, anime)
            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, detailFragment)
                .addToBackStack(null)
                .commit()
        }
        rvAnime.adapter = animeAdapter
    }

    private fun onCategoryClicked(category: Category) {
        Toast.makeText(requireContext(), "Clicked: ${category.title}", Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }

        const val INTENT_PARCELABLE = "anime_parcelable"
    }
}
