package com.example.liquorade.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.liquorade.repository.CategoryRepository

class CategoryViewModelFactory(private val categoryRepo: CategoryRepository) : ViewModelProvider.Factory {
    /**
     * Creates a ViewModel
     *
     * @param modelClass Class to make the ViewModel from
     * @return The ViewModel
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return CategoryViewModel(categoryRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}