package com.example.liquorade.cocktail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.domain.CocktailList
import com.example.liquorade.network.CocktailApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

enum class CocktailApiStatus { LOADING, ERROR, DONE }

class CocktailViewModel : ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

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
        getGinCocktails()
    }

    /**
     * Sets the value of the status LiveData to the Cocktails API status.
     */
    private fun getGinCocktails() {
        scope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                _cocktailList.value = CocktailApi.retrofitService.getGinDrinks()
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
                _cocktailList.value = CocktailList(ArrayList())
            }
        }
    }
}