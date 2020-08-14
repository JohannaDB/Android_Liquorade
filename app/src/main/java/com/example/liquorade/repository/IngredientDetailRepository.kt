package com.example.liquorade.repository

import com.example.liquorade.network.CocktailApiService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
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