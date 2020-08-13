package com.example.liquorade.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.domain.IngredientDetail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import javax.inject.Inject

class IngredientDetailRepository @Inject constructor(
    private val service: CocktailApiService
) {
    // Suspend functions can be called in a coroutine

    /**
     * Gets the ingredientDetails of a specific ingredient from the back-end
     *
     * @param ingredientName is the name of the ingredient
     */
    suspend fun getIngredientDetails(ingredientName: String) = withContext(IO) {
        service.getIngredientDetails(ingredientName).ingredients[0]
    }
}