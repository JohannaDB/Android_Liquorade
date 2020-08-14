package com.example.liquorade.cocktaildetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.repository.CocktailDetailRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class CocktailDetailViewModel @Inject constructor(private val detailRepo: CocktailDetailRepository) :
    ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private val _cocktailDetail = MutableLiveData<CocktailDetail>()

    val cocktailDetail: LiveData<CocktailDetail>
        get() = _cocktailDetail

    private var _ingredients: Map<String?, String?> = mapOf()
    val ingredients
        get() = _ingredients

    private val _cocktailId = MutableLiveData<String>()
    val cocktailId: LiveData<String>
        get() = _cocktailId

    /**
     * Gets the cocktail details from the Repository and sets the cocktailId, cocktail details and api status
     *
     * @param cocktailId The id of the cocktail
     */
    fun getCocktailDetails(cocktailId: String) {
        _cocktailId.value = cocktailId
        viewModelScope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                val detail = detailRepo.getCocktailDetails(cocktailId)
                _cocktailDetail.value = detail
                _ingredients = detail.ingredients
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
            }
        }
    }
}