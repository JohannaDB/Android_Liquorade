package com.example.liquorade.category

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.R
import com.example.liquorade.cocktail.CocktailViewModel
import com.example.liquorade.cocktail.CocktailViewModelFactory
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.database.asDomainCategory
import com.example.liquorade.databinding.FragmentCategoryBinding
import com.example.liquorade.repository.CategoryRepository
import kotlinx.android.synthetic.main.category_list_item.view.*
import javax.inject.Inject

class CategoryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: CategoryViewModelFactory

    private val viewModel by viewModels<CategoryViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as LiquoradeApplication).component.categoryComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryBinding.inflate(inflater)

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