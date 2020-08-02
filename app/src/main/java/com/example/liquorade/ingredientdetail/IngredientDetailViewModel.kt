package com.example.liquorade.ingredientdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.domain.IngredientDetail
import com.example.liquorade.repository.IngredientDetailRepository
import javax.inject.Inject

class IngredientDetailViewModel @Inject constructor(private val ingredientRepo: IngredientDetailRepository): ViewModel() {
    private val _ingredientDetail = MutableLiveData<IngredientDetail>()

    val ingredientDetail: LiveData<IngredientDetail>
        get() = _ingredientDetail

    private val _ingredientName = MutableLiveData<String>()
    val ingredientName: LiveData<String>
        get() = _ingredientName

    fun getIngredientDetails(ingredientName: String): LiveData<IngredientDetail> {
        if(ingredientName == "Dark rum") {
            _ingredientName.value = "Rum"
        } else {
            _ingredientName.value = ingredientName
        }
        return ingredientRepo.getIngredientDetails(_ingredientName.value.toString())
    }

    fun setIngredientDetails(ingredientdetail: IngredientDetail) {
        _ingredientDetail.value = ingredientdetail
    }
}