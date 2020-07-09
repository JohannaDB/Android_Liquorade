package com.example.liquorade.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.CategoryList
import com.example.liquorade.network.CocktailApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.function.Consumer

class CategoryViewModel : ViewModel() {
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

    val categories = listOf("Gin", "Vodka", "Bourbon", "Light rum", "Dark rum", "Triple sec", "Brandy", "Tequila", "Dry Vermouth", "Sweet Vermouth")

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getInformation()
    }

    private fun getInformation() {
        scope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                val temporaryCategoryList = CocktailApi.retrofitService.getCategories()
                val categoryList = ArrayList<Category>()
                temporaryCategoryList.drinks.forEach { category ->
                    if(categories.contains(category.strIngredient1)) {
                        categoryList.add(category)
                    }
                }
                _categoryList.value = categoryList
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
                _categoryList.value = ArrayList()
                Log.i("ERROR: ", e.message.toString())
            }
        }
    }

    fun displayCocktails(categoryName: String) {
        _navigation.value = categoryName
    }

    fun navigationComplete() {
        _navigation.value = null
    }
}