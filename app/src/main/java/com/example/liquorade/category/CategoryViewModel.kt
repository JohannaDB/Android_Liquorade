package com.example.liquorade.category

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.database.CategoryDatabaseDao
import com.example.liquorade.database.CategoryDb
import com.example.liquorade.domain.Category
import com.example.liquorade.network.CocktailApi
import com.example.liquorade.repository.CategoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class CategoryViewModel(val database: CategoryDatabaseDao, application: Application, val context: Context) : AndroidViewModel(application) {
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

    private val categoryRepo = CategoryRepository(database, context)

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

//    val categories = listOf("Gin", "Vodka", "Bourbon", "Light rum", "Dark rum", "Triple sec", "Brandy", "Tequila", "Dry Vermouth", "Sweet Vermouth")

    fun getCategories(): LiveData<List<CategoryDb>> {
        return categoryRepo.getCategories()
    }

    fun setCategories(categories: List<Category>) {
        _categoryList.value = categories
    }

//    fun getCategoriess() {
//        val tempCategories = categoryRepo.getCat()
//        val categorys = ArrayList<Category>()
//        tempCategories.drinks.forEach { category ->
//            if (categories.contains(category.strIngredient1)) {
//                categorys.add(category)
//            }
//        }
//        _categoryList.value = categoryRepo.insert(categorys)
//    }

    fun displayCocktails(categoryName: String) {
        _navigation.value = categoryName
    }

    fun navigationComplete() {
        _navigation.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}