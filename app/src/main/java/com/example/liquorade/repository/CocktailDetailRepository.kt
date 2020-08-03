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
    suspend fun getCocktailDetails(cocktailId: String) = withContext(Dispatchers.IO) {
        service.getCocktailDetails(cocktailId)
    }
}