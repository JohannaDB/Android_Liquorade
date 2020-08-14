package com.example.liquorade.cocktaildetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.R
import com.example.liquorade.databinding.FragmentCocktailDetailBinding
import javax.inject.Inject

class CocktailDetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: CocktailDetailViewModelFactory

    private val viewModel by viewModels<CocktailDetailViewModel> { viewModelFactory }

    private val args: CocktailDetailFragmentArgs by navArgs()

    /**
     * Method called once the fragment is associated with its activity
     * Tell Dagger to field inject into the fragment
     *
     * @param context Context of the application
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.cocktailDetailComponent()
            .create().inject(this)
    }

    /**
     * Method gets called once the fragment should inflate a view
     *
     * @param inflater The layoutInflater
     * @param container The ViewGroup
     * @param savedInstanceState The bundle created in onSaveInstanceState
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCocktailDetailBinding.inflate(inflater)

        // Giving the binding access to the CocktailDetailViewModel
        binding.viewModel = viewModel

        viewModel.getCocktailDetails(args.cocktailId)
        viewModel.cocktailDetail.observe(viewLifecycleOwner, Observer {
            binding.cocktailDetailIngredientList.adapter =
                CocktailDetailAdapter(requireContext(), R.layout.ingredient_list_item, it.ingredients.entries.toList())
        })


        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}