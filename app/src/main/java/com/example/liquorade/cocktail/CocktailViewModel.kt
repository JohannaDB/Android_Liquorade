package com.example.liquorade.cocktail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.domain.CocktailList
import com.example.liquorade.network.CocktailApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

enum class CocktailApiStatus { LOADING, ERROR, DONE }

class CocktailViewModel(categoryName: String, val database: CocktailDatabaseDao, application: Application) : AndroidViewModel(application) {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private val _category_Name = MutableLiveData<String>()
    val category_Name: LiveData<String>
        get() = _category_Name

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _cocktailList = MutableLiveData<CocktailList>()

    // The external immutable LiveData for the request status String
    val cocktailList: LiveData<CocktailList>
        get() = _cocktailList

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     * Call getGinCocktails() on init so we can display status immediately.
     */
    init {
        _category_Name.value = categoryName
        getCocktails(categoryName)
    }

    /**
     * Sets the value of the status LiveData to the Cocktails API status.
     */
    private fun getCocktails(categoryName: String) {
        scope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                _cocktailList.value = CocktailApi.retrofitService.getCocktails(categoryName)
                Log.i("CATEGORYY:", categoryName)
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
                Log.i("CATEGORYY:", e.message.toString())
                _cocktailList.value = CocktailList(ArrayList())
            }
        }
    }
}