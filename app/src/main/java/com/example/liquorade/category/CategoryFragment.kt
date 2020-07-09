package com.example.liquorade.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.liquorade.R
import com.example.liquorade.databinding.FragmentCategoryBinding
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryFragment : Fragment() {

    private val viewModel: CategoryViewModel by lazy {
        ViewModelProviders.of(this).get(CategoryViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCategoryBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

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

        setHasOptionsMenu(true)
        return binding.root
    }
}