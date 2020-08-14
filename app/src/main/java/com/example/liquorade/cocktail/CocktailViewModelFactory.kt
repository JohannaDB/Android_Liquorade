package com.example.liquorade.cocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.repository.CocktailRepository

class CocktailViewModelFactory(private val cocktailRepo: CocktailRepository) : ViewModelProvider.Factory {
    /**
     * Creates a ViewModel
     *
     * @param modelClass Class to make the ViewModel from
     * @return The ViewModel
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailViewModel::class.java)) {
            return CocktailViewModel(cocktailRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}