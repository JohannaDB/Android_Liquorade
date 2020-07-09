package com.example.liquorade.cocktail

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.liquorade.databinding.FragmentCocktailBinding

class CocktailFragment : Fragment() {
    /**
     * Lazily initialize our [CocktailViewModel].
     */
    private val viewModel: CocktailViewModel by lazy {
        ViewModelProviders.of(this).get(CocktailViewModel::class.java)
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentCocktailBinding.inflate(inflater)

        val categoryName = CocktailFragmentArgs.fromBundle(requireArguments()).categoryName
        Log.i("CATEGORY", categoryName)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)

        // Giving the binding access to the CocktailViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the cocktailGrid RecyclerView
        binding.cocktailGrid.adapter = CocktailAdapter()

        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * Inflates the overflow menu that contains filtering options.
     */
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.overflow_menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }
}