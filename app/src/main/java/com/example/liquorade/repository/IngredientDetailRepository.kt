package com.example.liquorade.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.domain.IngredientDetail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import javax.inject.Inject

class IngredientDetailRepository @Inject constructor(
    private val service: CocktailApiService,
    private val connectionChecker: ConnectionChecker
) {
    private var job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    fun getIngredientDetails(ingredientName: String) : LiveData<IngredientDetail> {
        var ingredientDetails  = MediatorLiveData<IngredientDetail>()
        scope.launch {
            try {
                if (connectionChecker.isInternetAvailable()) {
                    withContext(Dispatchers.Main) {
                        ingredientDetails.value = service.getIngredientDetails(ingredientName).ingredients[0]
                    }
                } else {
                    ingredientDetails.value = null
                }
            } catch (e: Exception) {
                Log.i("ERROR", e.message.toString())
            }
        }
        return ingredientDetails
    }
}