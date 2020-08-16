package com.example.liquorade.cocktail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.repository.CocktailRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Api status
 */
enum class CocktailApiStatus { LOADING, ERROR, DONE }

class CocktailViewModel @Inject constructor(private val cocktailRepo: CocktailRepository) :
    ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private var _categoryName: String = ""
    val categoryName: String
        get() = _categoryName

    private val _cocktailList = MutableLiveData<List<Cocktail>>()

    val cocktailList: LiveData<List<Cocktail>>
        get() = _cocktailList

    private val _navigation = MutableLiveData<String>()

    val navigation: LiveData<String>
        get() = _navigation

    /**
     * Gets the list of cocktails from the Repository and sets the api status to LOADING and ERROR or DONE
     */
    fun getCocktails(categoryName: String) {
        _categoryName = categoryName
        viewModelScope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                val cocktails = cocktailRepo.getCocktails(categoryName)
                _cocktailList.value = cocktails
                if (cocktails.isEmpty()) {
                    _status.value = CocktailApiStatus.ERROR
                } else {
                    _status.value = CocktailApiStatus.DONE
                }
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
            }
        }
    }

    /**
     * Sets the navigation value to the id of selected cocktail
     *
     * @param cocktailId The id of the selected cocktail
     */
    fun displayCocktailDetails(cocktailId: String) {
        _navigation.value = cocktailId
    }

    /**
     * Method gets called when the navigation is completed
     */
    fun navigationComplete() {
        _navigation.value = null
    }
}
