package com.example.liquorade.randomcocktail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.R
import com.example.liquorade.cocktaildetail.CocktailDetailAdapter
import com.example.liquorade.databinding.FragmentIngredientDetailBinding
import com.example.liquorade.databinding.FragmentRandomCocktailBinding
import javax.inject.Inject

class RandomCocktailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: RandomCocktailViewModelFactory

    private val viewModel by viewModels<RandomCocktailViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.randomCocktailComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentRandomCocktailBinding.inflate(inflater)

        binding.viewModel = viewModel


        viewModel.randomCocktail.observe(viewLifecycleOwner, Observer {
            binding.ingredientListRandom.adapter =
                CocktailDetailAdapter(requireContext(), R.layout.ingredient_list_item, it.ingredients.entries.toList())
        })

        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}