package com.example.liquorade.cocktail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.database.asDomainCategory
import com.example.liquorade.database.asDomainCocktail
import com.example.liquorade.databinding.FragmentCocktailBinding
import javax.inject.Inject

class CocktailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: CocktailViewModelFactory

    private val viewModel: CocktailViewModel by viewModels<CocktailViewModel> { viewModelFactory }

    private val args: CocktailFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as LiquoradeApplication).component.cocktailComponent().create().inject(this)
    }
    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentCocktailBinding.inflate(inflater)

        // Giving the binding access to the CocktailViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the cocktailGrid RecyclerView
        binding.cocktailGrid.adapter = CocktailAdapter()

        viewModel.getCocktails(args.categoryName).observe(viewLifecycleOwner, Observer{
            viewModel.setCocktails(it.asDomainCocktail())
        })

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)
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