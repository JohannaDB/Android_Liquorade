package com.example.liquorade.randomcocktail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.repository.RandomCocktailRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class RandomCocktailViewModel @Inject constructor(private val repository: RandomCocktailRepository) : ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private val _randomCocktail = MutableLiveData<CocktailDetail>()

    val randomCocktail: LiveData<CocktailDetail>
        get() = _randomCocktail

    private var viewModelJob = Job()
    private val scope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getRandomCocktail()
    }

    fun getRandomCocktail() {
        scope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                _randomCocktail.value = repository.getRandomCocktail()
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
                _randomCocktail.value = null
                Log.i("ERROR: ", e.message.toString())
            }
        }
    }
}