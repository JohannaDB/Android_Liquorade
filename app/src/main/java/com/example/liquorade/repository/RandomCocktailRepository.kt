package com.example.liquorade.repository

import com.example.liquorade.network.CocktailApiService
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomCocktailRepository @Inject constructor(
    private val service: CocktailApiService
) {
    // Suspend functions can be called in a coroutine

    /**
     * Gets the cocktailDetails of a random cocktail from the back-end
     */
    suspend fun getRandomCocktail() = withContext(IO) {
        service.getRandomCocktail()
    }
}