package com.example.liquorade.randomcocktail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.repository.RandomCocktailRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class RandomCocktailViewModel @Inject constructor(private val repository: RandomCocktailRepository) : ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private val _randomCocktail = MutableLiveData<CocktailDetail>()

    val randomCocktail: LiveData<CocktailDetail>
        get() = _randomCocktail

    init {
        getRandomCocktail()
    }

    /**
     * Gets the random cocktail details from the Repository and sets the random cocktail details and api status
     */
    fun getRandomCocktail() {
        viewModelScope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                _randomCocktail.value = repository.getRandomCocktail()
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
            }
        }
    }
}