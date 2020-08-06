package com.example.liquorade.cocktaildetail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.R
import com.example.liquorade.category.CategoryAdapter
import com.example.liquorade.category.CategoryFragmentDirections
import com.example.liquorade.category.OnClickListener
import com.example.liquorade.cocktail.CocktailFragmentArgs
import com.example.liquorade.database.asDomainCategory
import com.example.liquorade.databinding.FragmentCategoryBinding
import com.example.liquorade.databinding.FragmentCocktailDetailBinding
import javax.inject.Inject

class CocktailDetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: CocktailDetailViewModelFactory

    private val viewModel by viewModels<CocktailDetailViewModel> { viewModelFactory }

    private val args: CocktailDetailFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.cocktailDetailComponent()
            .create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCocktailDetailBinding.inflate(inflater)

        // Giving the binding access to the CocktailDetailViewModel
        binding.viewModel = viewModel

//        viewModel.getCocktailDetails(args.cocktailId).observe(viewLifecycleOwner, Observer{
//            viewModel.setCocktailDetails(it)
//            viewModel.setIngredients(it.ingredients)
//            binding.ingredientList.adapter = CocktailDetailAdapter(requireContext(), R.layout.ingredient_list_item, it.ingredients.entries.toList())
//        })

        viewModel.getCocktailDetails(args.cocktailId)
        viewModel.cocktailDetail.observe(viewLifecycleOwner, Observer {
            binding.ingredientList.adapter =
                CocktailDetailAdapter(requireContext(), R.layout.ingredient_list_item, it.ingredients.entries.toList())
        })


        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}