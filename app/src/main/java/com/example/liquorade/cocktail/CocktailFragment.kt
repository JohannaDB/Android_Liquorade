package com.example.liquorade.cocktail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.R
import com.example.liquorade.category.OnClickListener
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentCocktailBinding.inflate(inflater)

        // Giving the binding access to the CocktailViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the cocktailGrid RecyclerView
        binding.cocktailGrid.adapter = CocktailAdapter( OnClickListener { viewModel.displayCocktailDetails(it) })

        viewModel.navigation.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                this.findNavController()
                    .navigate(CocktailFragmentDirections.actionCocktailFragmentToCocktailDetailFragment(it))
                viewModel.navigationComplete()
            }
        })

        binding.infoButton.setOnClickListener { _ ->
            if(viewModel.category_Name != "") {
                findNavController().navigate(CocktailFragmentDirections.actionCocktailFragmentToIngredientDetailFragment(viewModel.category_Name))
            }
        }

        viewModel.getCocktails(args.categoryName).observe(viewLifecycleOwner, Observer{
            viewModel.setCocktails(it.asDomainCocktail())
        })

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}