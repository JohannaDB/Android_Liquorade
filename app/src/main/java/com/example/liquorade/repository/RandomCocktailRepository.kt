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
    suspend fun getRandomCocktail() = withContext(IO) {
        service.getRandomCocktail()
    }
}