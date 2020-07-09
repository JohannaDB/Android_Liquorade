package com.example.liquorade.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.liquorade.cocktail.CocktailAdapter
import com.example.liquorade.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private val viewModel: CategoryViewModel by lazy {
        ViewModelProviders.of(this).get(CategoryViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentCategoryBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the CategoryViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the categoryGrid RecyclerView
        binding.categoryGrid.adapter = CategoryAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }
}