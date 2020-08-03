package com.example.liquorade.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.database.CocktailDb
import com.example.liquorade.domain.asDatabaseCategory
import com.example.liquorade.domain.asDatabaseCocktail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val service: CocktailApiService,
    private val cocktailDao: CocktailDatabaseDao,
    private val connectionChecker: ConnectionChecker
) {
    private var job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    fun getCocktails(categoryName: String) : LiveData<List<CocktailDb>> {
        var test = MediatorLiveData<List<CocktailDb>>()
        scope.launch {
            try {
                if (connectionChecker.isInternetAvailable()) {
                    val cocktailList = service.getCocktails(categoryName)
                    cocktailDao.insert(cocktailList.drinks.asDatabaseCocktail(categoryName))
                    withContext(Dispatchers.Main) {
                        test.value = cocktailList.drinks.asDatabaseCocktail(categoryName)
                    }
                } else {
                    withContext(Dispatchers.Main){
                        test.addSource(cocktailDao.getCocktails(categoryName)){
                            test.removeSource(cocktailDao.getCocktails(categoryName))
                            test.value = it
                        }
                    }
                }
            } catch (e: Exception) {
                Log.i("ERROR", e.message.toString())
            }
        }
        return test
    }
}