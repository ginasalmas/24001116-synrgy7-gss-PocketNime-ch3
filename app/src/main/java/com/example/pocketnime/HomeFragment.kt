// HomeFragment.kt
package com.example.pocketnime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.rvCategory)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        categoryAdapter = CategoryAdapter(getCategoryList())
        recyclerView.adapter = categoryAdapter

        return view
    }

    private fun getCategoryList(): List<Categories> {
        val categories = resources.getStringArray(R.array.data_name)
        val images = resources.obtainTypedArray(R.array.data_photo)
        val categoryList = mutableListOf<Categories>()
        for (i in categories.indices) {
            categoryList.add(Categories(categories[i], images.getResourceId(i, -1)))
        }
        images.recycle()
        return categoryList
    }
}
