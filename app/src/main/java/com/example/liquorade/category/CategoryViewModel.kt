package com.example.liquorade.category

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.database.CategoryDatabaseDao
import com.example.liquorade.database.CategoryDb
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.repository.CategoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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

    fun getCategories(): LiveData<List<Category>> {
        if (_categoryList.value == null) {
            _status.value = CocktailApiStatus.LOADING
            return categoryRepo.getCategories()
        }
        return categoryList
    }

    fun setCategories(categories: List<Category>) {
        if (_categoryList.value != categories) {
            _categoryList.value = categories
        }
        if(categories.isEmpty()) {
            _status.value = CocktailApiStatus.ERROR
        } else {
            _status.value = CocktailApiStatus.DONE
        }
    }

    fun displayCocktails(categoryName: String) {
        _navigation.value = categoryName
    }

    fun navigationComplete() {
        _navigation.value = null
    }
}