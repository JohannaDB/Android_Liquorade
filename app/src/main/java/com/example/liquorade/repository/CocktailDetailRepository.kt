package com.example.liquorade.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.database.CategoryDb
import com.example.liquorade.database.CocktailDb
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.domain.asDatabaseCocktail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import javax.inject.Inject

class CocktailDetailRepository @Inject constructor(
    private val service: CocktailApiService,
    private val connectionChecker: ConnectionChecker
) {
    private var job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    fun getCocktailDetails(cocktailId: String) : LiveData<CocktailDetail> {
        var cocktailDetails  = MediatorLiveData<CocktailDetail>()
        scope.launch {
            try {
                if (connectionChecker.isInternetAvailable()) {
                    withContext(Dispatchers.Main) {
                        cocktailDetails.value = service.getCocktailDetails(cocktailId).drinks[0]
                    }
                } else {
                    cocktailDetails.value = null
                }
            } catch (e: Exception) {
                Log.i("ERROR", e.message.toString())
            }
        }
        return cocktailDetails
    }
}