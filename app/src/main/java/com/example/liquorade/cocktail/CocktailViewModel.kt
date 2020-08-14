package com.example.liquorade.cocktail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.repository.CocktailRepository
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

    /**
     * Gets the list of cocktails from the Repository and sets the api status to LOADING
     *
     * @return LiveData list of cocktails
     */
    fun getCocktails(categoryName: String): LiveData<List<Cocktail>> {
        if (_cocktailList.value == null) {
            _status.value = CocktailApiStatus.LOADING
            _category_Name = categoryName
            return cocktailRepo.getCocktails(categoryName)
        }
        return cocktailList
    }

    /**
     * Sets the cocktailList to the given list of cocktails
     * If the list is empty, the api status is set to ERROR, otherwise to DONE
     *
     * @param cocktails List of cocktails
     */
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