package com.example.liquorade.category

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.cocktail.CocktailViewModel
import com.example.liquorade.database.CategoryDatabaseDao

class CategoryViewModelFactory(private val database: CategoryDatabaseDao, private val application: Application, val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return CategoryViewModel(database, application, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}