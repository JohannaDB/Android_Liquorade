package com.example.liquorade.cocktaildetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.repository.CocktailDetailRepository

class CocktailDetailViewModelFactory(private val detailRepo: CocktailDetailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CocktailDetailViewModel::class.java)) {
            return CocktailDetailViewModel(detailRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}