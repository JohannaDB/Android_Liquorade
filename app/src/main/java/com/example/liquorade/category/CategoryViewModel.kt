package com.example.liquorade.category

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.database.CategoryDatabaseDao
import com.example.liquorade.database.CategoryDb
import com.example.liquorade.domain.Category
import com.example.liquorade.repository.CategoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) : ViewModel() {
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

    private val categoryRepo = repository

    fun getCategories(): LiveData<List<CategoryDb>> {
        return categoryRepo.getCategories()
    }

    fun setCategories(categories: List<Category>) {
        _categoryList.value = categories
    }

    fun displayCocktails(categoryName: String) {
        _navigation.value = categoryName
    }

    fun navigationComplete() {
        _navigation.value = null
    }
}