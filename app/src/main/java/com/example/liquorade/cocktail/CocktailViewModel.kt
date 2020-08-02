package com.example.liquorade.cocktail

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.database.CategoryDb
import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.database.CocktailDb
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.domain.CocktailList
import com.example.liquorade.repository.CocktailRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

enum class CocktailApiStatus { LOADING, ERROR, DONE }

class CocktailViewModel @Inject constructor(private val cocktailRepo: CocktailRepository) : ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private var _category_Name: String = ""
    val category_Name: String
        get() = _category_Name

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _cocktailList = MutableLiveData<List<Cocktail>>()

    // The external immutable LiveData for the request status String
    val cocktailList: LiveData<List<Cocktail>>
        get() = _cocktailList

    private val _navigation = MutableLiveData<String>()

    val navigation: LiveData<String>
        get() = _navigation

    fun getCocktails(categoryName: String): LiveData<List<CocktailDb>> {
        _category_Name = categoryName
        return cocktailRepo.getCocktails(categoryName)
    }

    fun setCocktails(cocktails: List<Cocktail>) {
        _cocktailList.value = cocktails
    }

    fun displayCocktailDetails(cocktailId: String) {
        _navigation.value = cocktailId
    }

    fun navigationComplete() {
        _navigation.value = null
    }
}