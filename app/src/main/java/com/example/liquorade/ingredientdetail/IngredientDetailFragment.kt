package com.example.liquorade.ingredientdetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.databinding.FragmentIngredientDetailBinding
import javax.inject.Inject

class IngredientDetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: IngredientDetailViewModelFactory

    private val viewModel by viewModels<IngredientDetailViewModel> { viewModelFactory }

    private val args: IngredientDetailFragmentArgs by navArgs()

    /**
     * Method called once the fragment is associated with its activity
     * Tell Dagger to field inject into the fragment
     *
     * @param context Context of the application
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.ingredientDetailComponent().create().inject(this)
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
        val binding = FragmentIngredientDetailBinding.inflate(inflater)

        binding.viewModel = viewModel

        viewModel.getIngredientDetails(args.ingredientName)

        binding.ingredientDetailRefreshLayout.setOnRefreshListener {
            viewModel.getIngredientDetails(args.ingredientName)
            binding.ingredientDetailRefreshLayout.isRefreshing = false
        }

        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }
}
