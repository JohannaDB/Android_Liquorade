package com.example.liquorade.randomcocktail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.ingredientdetail.IngredientDetailViewModel
import com.example.liquorade.repository.RandomCocktailRepository

class RandomCocktailViewModelFactory(private val repository: RandomCocktailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RandomCocktailViewModel::class.java)) {
            return RandomCocktailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}