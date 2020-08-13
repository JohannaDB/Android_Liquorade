package com.example.liquorade.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.domain.IngredientDetail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
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