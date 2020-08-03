package com.example.liquorade.cocktail

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.*
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

class CocktailViewModel @Inject constructor(private val cocktailRepo: CocktailRepository) :
    ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private var _category_Name: String = ""
    val category_Name: String
        get() = _category_Name

    private val _cocktailList = MutableLiveData<List<Cocktail>>()

    val cocktailList: LiveData<List<Cocktail>>
        get() = _cocktailList

    private val _navigation = MutableLiveData<String>()


    val navigation: LiveData<String>
        get() = _navigation

    fun getCocktails(categoryName: String): LiveData<List<Cocktail>> {
        if (_cocktailList.value == null) {
            _status.value = CocktailApiStatus.LOADING
            _category_Name = categoryName
            return cocktailRepo.getCocktails(categoryName)
        }
        return cocktailList
    }

    fun setCocktails(cocktails: List<Cocktail>) {
        if (_cocktailList.value != cocktails) {
            _cocktailList.value = cocktails
        }
        if(cocktails.isEmpty()) {
            _status.value = CocktailApiStatus.ERROR
        } else {
            _status.value = CocktailApiStatus.DONE
        }
    }

    fun displayCocktailDetails(cocktailId: String) {
        _navigation.value = cocktailId
    }

    fun navigationComplete() {
        _navigation.value = null
    }
}