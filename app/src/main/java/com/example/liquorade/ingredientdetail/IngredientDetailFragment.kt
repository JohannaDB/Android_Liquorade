package com.example.liquorade.ingredientdetail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.databinding.FragmentIngredientDetailBinding
import javax.inject.Inject

class IngredientDetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: IngredientDetailViewModelFactory

    private val viewModel by viewModels<IngredientDetailViewModel> { viewModelFactory }

    private val args: IngredientDetailFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.ingredientDetailComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentIngredientDetailBinding.inflate(inflater)

        binding.viewModel = viewModel

//        viewModel.getIngredientDetails(args.ingredientName).observe(viewLifecycleOwner, Observer{
//            viewModel.setIngredientDetails(it)
//        })
//
        viewModel.getIngredientDetails(args.ingredientName)

        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}