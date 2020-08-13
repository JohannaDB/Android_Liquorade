package com.example.liquorade.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import javax.inject.Inject

class CocktailDetailRepository @Inject constructor(
    private val service: CocktailApiService
) {
    // Suspend functions can be called in a coroutine

    /**
     * Gets the cocktail details of a specific cocktail from the back-end
     *
     * @param cocktailId is the id of the cocktail
     */
    suspend fun getCocktailDetails(cocktailId: String) = withContext(Dispatchers.IO) {
        service.getCocktailDetails(cocktailId)
    }
}