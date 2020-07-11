package com.example.liquorade.cocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CocktailViewModelFactory(private val categoryName: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailViewModel::class.java)) {
            return CocktailViewModel(categoryName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}