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

class CocktailViewModel : ViewModel() {
    // The internal MutableLiveData String that stores the status of the most recent request
    private val _response = MutableLiveData<CocktailList>()

    // The external immutable LiveData for the request status String
    val response: LiveData<CocktailList>
        get() = _response

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    /**
     * Call getAlcoholicCocktails() on init so we can display status immediately.
     */
    init {
        getAlcoholicCocktails()
    }

    /**
     * Sets the value of the status LiveData to the Cocktails API status.
     */
    private fun getAlcoholicCocktails() {
        scope.launch {
            try {
                _response.value = CocktailApi.retrofitService.getAlcoholic()

            } catch (e: Exception) {
                Log.i("API ERROR: ", e.message.toString())
            }
        }
    }
}