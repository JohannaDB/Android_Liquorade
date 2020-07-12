package com.example.liquorade.cocktail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.database.CocktailDatabaseDao

class CocktailViewModelFactory(private val categoryName: String, private val database: CocktailDatabaseDao, private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailViewModel::class.java)) {
            return CocktailViewModel(categoryName, database, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}