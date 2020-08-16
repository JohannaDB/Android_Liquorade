package com.example.liquorade.cocktail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.category.OnClickListener
import com.example.liquorade.databinding.FragmentCocktailBinding
import javax.inject.Inject

class CocktailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: CocktailViewModelFactory

    private val viewModel: CocktailViewModel by viewModels<CocktailViewModel> { viewModelFactory }

    private val args: CocktailFragmentArgs by navArgs()

    /**
     * Method called once the fragment is associated with its activity
     * Tell Dagger to field inject into the fragment
     *
     * @param context Context of the application
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.cocktailComponent().create().inject(this)
    }

    /**
     * Method gets called once the fragment should inflate a view
     *
     * @param inflater The layoutInflater
     * @param container The ViewGroup
     * @param savedInstanceState The bundle created in onSaveInstanceState
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCocktailBinding.inflate(inflater)

        // Giving the binding access to the CocktailViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the cocktailGrid RecyclerView
        binding.cocktailGrid.adapter = CocktailAdapter(OnClickListener { viewModel.displayCocktailDetails(it) })

        viewModel.navigation.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    this.findNavController()
                        .navigate(CocktailFragmentDirections.actionCocktailFragmentToCocktailDetailFragment(it))
                    viewModel.navigationComplete()
                }
            }
        )

        binding.cocktailInfoButton.setOnClickListener { _ ->
            if (viewModel.categoryName != "") {
                findNavController().navigate(CocktailFragmentDirections.actionCocktailFragmentToIngredientDetailFragment(viewModel.categoryName))
            }
        }

        viewModel.getCocktails(args.categoryName)

        binding.cocktailRefreshLayout.setOnRefreshListener {
            viewModel.getCocktails(args.categoryName)
            binding.cocktailRefreshLayout.isRefreshing = false
        }

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}
