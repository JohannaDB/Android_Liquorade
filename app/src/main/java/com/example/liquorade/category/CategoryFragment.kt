package com.example.liquorade.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.liquorade.LiquoradeApplication
import com.example.liquorade.R
import com.example.liquorade.databinding.FragmentCategoryBinding
import javax.inject.Inject

class CategoryFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: CategoryViewModelFactory

    private val viewModel by viewModels<CategoryViewModel> { viewModelFactory }

    /**
     * Method called once the fragment is associated with its activity
     * Tell Dagger to field inject into the fragment
     *
     * @param context Context of the application
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as LiquoradeApplication).component.categoryComponent().create().inject(this)
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
        val binding = FragmentCategoryBinding.inflate(inflater)

        // Giving the binding access to the CategoryViewModel
        binding.viewModel = viewModel

        // Sets the adapter of the categoryGrid RecyclerView
        binding.categoryGrid.adapter =
            CategoryAdapter(OnClickListener { viewModel.displayCocktails(it) })
        viewModel.navigation.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    this.findNavController()
                        .navigate(CategoryFragmentDirections.actionCategoryFragmentToCocktailFragment(it))
                    viewModel.navigationComplete()
                }
            }
        )

        viewModel.getCategories()

        binding.categoryRefreshLayout.setOnRefreshListener {
            viewModel.getCategories()
            binding.categoryRefreshLayout.isRefreshing = false
        }

        binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * Specifies the options menu for an activity, the menu resource gets inflated into the menu provided in the callback
     *
     * @param menu The Menu callback
     * @param inflater The MenuInflater
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    /**
     *
     * Describes what should happen when a MenuItem is selected
     *
     * @param item The selected MenuItem
     * @return Boolean that indicates if the event handling was successful
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) ||
            super.onOptionsItemSelected(item)
    }
}
