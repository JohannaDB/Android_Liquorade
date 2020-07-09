package com.example.liquorade.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.Category
import com.example.liquorade.network.CocktailApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class CategoryViewModel : ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _categoryList = MutableLiveData<List<Category>>()

    // The external immutable LiveData for the request status String
    val categoryList: LiveData<List<Category>>
        get() = _categoryList

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getGinInformation()
    }

    private fun getGinInformation() {
        scope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                val category = CocktailApi.retrofitService.getGinInformation()
                _categoryList.value!!.toMutableList()!!.add(category)
                Log.i("ERROR: ", _categoryList.value.toString())
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
                //_categoryList.value =
                Log.i("ERROR: ", e.message.toString())
            }
        }
    }
}