package com.example.liquorade.cocktaildetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.repository.CocktailDetailRepository
import javax.inject.Inject

class CocktailDetailViewModel @Inject constructor(private val detailRepo: CocktailDetailRepository) : ViewModel() {
    private val _cocktailDetail = MutableLiveData<CocktailDetail>()

    val cocktailDetail: LiveData<CocktailDetail>
        get() = _cocktailDetail

    private val _ingredientList = ArrayList<String>()
    private val _ingredients = MutableLiveData<List<String>>()

    val ingredients: LiveData<List<String>>
        get() = _ingredients

    private val _measurementList = ArrayList<String>()
    private val _measurements = MutableLiveData<List<String>>()

    val measurements: LiveData<List<String>>
        get() = _measurements

    private val _cocktailId = MutableLiveData<String>()
    val cocktailId: LiveData<String>
        get() = _cocktailId

    fun getCocktailDetails(cocktailId: String): LiveData<CocktailDetail> {
        _cocktailId.value = cocktailId
        return detailRepo.getCocktailDetails(cocktailId)
    }

    fun setCocktailDetails(cocktaildetail: CocktailDetail) {
        _cocktailDetail.value = cocktaildetail
        setIngredients()
    }

    fun setIngredients() {
        if(_cocktailDetail.value?.strIngredient1 != null && _cocktailDetail.value?.strMeasure1 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient1!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure1!!)
        }
        if(_cocktailDetail.value?.strIngredient2 != null && _cocktailDetail.value?.strMeasure2 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient2!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure2!!)
        }
        if(_cocktailDetail.value?.strIngredient3 != null && _cocktailDetail.value?.strMeasure3 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient3!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure3!!)
        }
        if(_cocktailDetail.value?.strIngredient4 != null && _cocktailDetail.value?.strMeasure4 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient4!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure4!!)
        }
        if(_cocktailDetail.value?.strIngredient5 != null && _cocktailDetail.value?.strMeasure5 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient5!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure5!!)
        }
        if(_cocktailDetail.value?.strIngredient6 != null && _cocktailDetail.value?.strMeasure6 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient6!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure6!!)
        }
        if(_cocktailDetail.value?.strIngredient7 != null && _cocktailDetail.value?.strMeasure7 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient7!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure7!!)
        }
        if(_cocktailDetail.value?.strIngredient8 != null && _cocktailDetail.value?.strMeasure8 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient8!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure8!!)
        }
        if(_cocktailDetail.value?.strIngredient9 != null && _cocktailDetail.value?.strMeasure9 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient9!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure9!!)
        }
        if(_cocktailDetail.value?.strIngredient10 != null && _cocktailDetail.value?.strMeasure10 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient10!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure10!!)
        }
        if(_cocktailDetail.value?.strIngredient11 != null && _cocktailDetail.value?.strMeasure11 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient11!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure11!!)
        }
        if(_cocktailDetail.value?.strIngredient12 != null && _cocktailDetail.value?.strMeasure12 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient12!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure12!!)
        }
        if(_cocktailDetail.value?.strIngredient13 != null && _cocktailDetail.value?.strMeasure13 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient13!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure13!!)
        }
        if(_cocktailDetail.value?.strIngredient14 != null && _cocktailDetail.value?.strMeasure14 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient14!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure14!!)
        }
        if(_cocktailDetail.value?.strIngredient15 != null && _cocktailDetail.value?.strMeasure15 != null) {
            _ingredientList.add(_cocktailDetail.value?.strIngredient15!!)
            _measurementList.add(_cocktailDetail.value?.strMeasure15!!)
        }
        _ingredients.value = _ingredientList
        _measurements.value = _measurementList
        Log.i("INGREDIENTS", _ingredients.value.toString() + _measurements.value.toString())
    }
}