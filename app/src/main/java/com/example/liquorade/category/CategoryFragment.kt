package com.example.liquorade.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.liquorade.R
import com.example.liquorade.cocktail.CocktailViewModel
import com.example.liquorade.cocktail.CocktailViewModelFactory
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.database.asDomainCategory
import com.example.liquorade.databinding.FragmentCategoryBinding
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryFragment : Fragment() {

    private lateinit var viewModelFactory: CategoryViewModelFactory
    private lateinit var viewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = CocktailDatabase.getInstance(application).categoryDatabaseDao

        viewModelFactory = CategoryViewModelFactory(dataSource, application)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CategoryViewModel::class.java)

        // Giving the binding access to the CategoryViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the categoryGrid RecyclerView
        binding.categoryGrid.adapter =
            CategoryAdapter(OnClickListener { viewModel.displayCocktails(it) })
        viewModel.navigation.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                this.findNavController()
                    .navigate(CategoryFragmentDirections.actionCategoryFragmentToCocktailFragment(it))
                viewModel.navigationComplete()
            }
        })

        viewModel.getCategories().observe(viewLifecycleOwner, Observer{
            viewModel.setCategories(it.asDomainCategory())
        })

        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}