package com.example.liquorade.randomcocktail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.R
import com.example.liquorade.cocktaildetail.CocktailDetailAdapter
import com.example.liquorade.databinding.FragmentRandomCocktailBinding
import javax.inject.Inject

class RandomCocktailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: RandomCocktailViewModelFactory

    private val viewModel by viewModels<RandomCocktailViewModel> { viewModelFactory }

    /**
     * Method called once the fragment is associated with its activity
     * Tell Dagger to field inject into the fragment
     *
     * @param context Context of the application
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.randomCocktailComponent().create().inject(this)
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

        val binding = FragmentRandomCocktailBinding.inflate(inflater)

        binding.viewModel = viewModel


        viewModel.randomCocktail.observe(viewLifecycleOwner, Observer {
            binding.randomCocktailIngredients.adapter =
                CocktailDetailAdapter(requireContext(), R.layout.ingredient_list_item, it.ingredients.entries.toList())
        })

        binding.randomCocktailButton.setOnClickListener { _ ->
            viewModel.getRandomCocktail()
        }

        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}