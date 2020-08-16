package com.example.liquorade.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.Category
import com.example.liquorade.repository.CategoryRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val categoryRepo: CategoryRepository) : ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _categoryList = MutableLiveData<List<Category>>()

    // The external immutable LiveData for the request status String
    val categoryList: LiveData<List<Category>>
        get() = _categoryList

    private val _navigation = MutableLiveData<String>()

    val navigation: LiveData<String>
        get() = _navigation

    /**
     * Gets the list of categories from the Repository and sets the api status to LOADING and ERROR or DONE
     */
    fun getCategories() {
        viewModelScope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                val categories = categoryRepo.getCategories()
                _categoryList.value = categories
                if (categories.isEmpty()) {
                    _status.value = CocktailApiStatus.ERROR
                } else {
                    _status.value = CocktailApiStatus.DONE
                }
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
            }
        }
    }

    /**
     * Sets the navigation value to the name of selected category
     *
     * @param categoryName The name of the selected category
     */
    fun displayCocktails(categoryName: String) {
        _navigation.value = categoryName
    }

    /**
     * Method gets called when the navigation is completed
     */
    fun navigationComplete() {
        _navigation.value = null
    }
}
