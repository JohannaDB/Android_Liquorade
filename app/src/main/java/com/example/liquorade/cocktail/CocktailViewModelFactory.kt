package com.example.liquorade.cocktail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.repository.CocktailRepository

class CocktailViewModelFactory(private val cocktailRepo: CocktailRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailViewModel::class.java)) {
            return CocktailViewModel(cocktailRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}