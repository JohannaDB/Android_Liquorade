package com.example.liquorade.ingredientdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.repository.IngredientDetailRepository

class IngredientDetailViewModelFactory(private val detailRepo: IngredientDetailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IngredientDetailViewModel::class.java)) {
            return IngredientDetailViewModel(detailRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}