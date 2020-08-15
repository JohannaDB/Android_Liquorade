package com.example.liquorade.ingredientdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liquorade.cocktail.CocktailApiStatus
import com.example.liquorade.domain.IngredientDetail
import com.example.liquorade.repository.IngredientDetailRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class IngredientDetailViewModel @Inject constructor(private val ingredientRepo: IngredientDetailRepository) : ViewModel() {
    private val _status = MutableLiveData<CocktailApiStatus>()

    val status: LiveData<CocktailApiStatus>
        get() = _status

    private val _ingredientDetail = MutableLiveData<IngredientDetail>()

    val ingredientDetail: LiveData<IngredientDetail>
        get() = _ingredientDetail

    private val _ingredientName = MutableLiveData<String>()
    val ingredientName: LiveData<String>
        get() = _ingredientName

    /**
     * Gets the ingredient details from the Repository and sets the ingredient name, ingredient details and api status
     *
     * @param ingredientName The name of the ingredient
     */
    fun getIngredientDetails(ingredientName: String) {
        _ingredientName.value = if (ingredientName == "Dark rum") "Rum" else ingredientName
        viewModelScope.launch {
            try {
                _status.value = CocktailApiStatus.LOADING
                val detail = ingredientRepo.getIngredientDetails(_ingredientName.value.toString())
                _ingredientDetail.value = detail
                _status.value = CocktailApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CocktailApiStatus.ERROR
            }
        }
    }
}
