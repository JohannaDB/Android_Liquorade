package com.example.liquorade.cocktaildetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.domain.CocktailDetailNetwork
import com.example.liquorade.repository.CocktailDetailRepository
import javax.inject.Inject

class CocktailDetailViewModel @Inject constructor(private val detailRepo: CocktailDetailRepository) :
    ViewModel() {
    private val _cocktailDetail = MutableLiveData<CocktailDetail>()

    val cocktailDetail: LiveData<CocktailDetail>
        get() = _cocktailDetail

    private var _ingredients: Map<String?, String?> = mapOf()
    val ingredients
        get() = _ingredients

    private val _cocktailId = MutableLiveData<String>()
    val cocktailId: LiveData<String>
        get() = _cocktailId

    fun getCocktailDetails(cocktailId: String): LiveData<CocktailDetail> {
        _cocktailId.value = cocktailId
        return detailRepo.getCocktailDetails(cocktailId)
    }

    fun setCocktailDetails(cocktaildetail: CocktailDetail) {
        _cocktailDetail.value = cocktaildetail
    }

    fun setIngredients(ingredients: Map<String?, String?>) {
        _ingredients = ingredients
    }
}