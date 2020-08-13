package com.example.liquorade.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.database.CocktailDb
import com.example.liquorade.database.asDomainCocktail
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.domain.asDatabaseCocktail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.lang.Exception
import java.lang.IllegalStateException
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val service: CocktailApiService,
    private val cocktailDao: CocktailDatabaseDao,
    private val connectionChecker: ConnectionChecker
) {
    private var job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    /**
     * Gets a list of cocktails from the back-end or from the local database, depending on the internet status
     *
     * @param categoryName is the specified category name of the cocktails
     * @return LiveData list of cocktails
     */
    fun getCocktails(categoryName: String) : LiveData<List<Cocktail>> {
        var test = MediatorLiveData<List<Cocktail>>()
        scope.launch {
                if (connectionChecker.isInternetAvailable()) {
                    val cocktailList = service.getCocktails(categoryName)
                    cocktailDao.insert(cocktailList.drinks.asDatabaseCocktail(categoryName))
                    withContext(Dispatchers.Main) {
                        test.value = cocktailList.drinks
                    }
                } else {
                    withContext(Dispatchers.Main){
                        test.addSource(cocktailDao.getCocktails(categoryName)){
                            test.removeSource(cocktailDao.getCocktails(categoryName))
                            test.value = it.asDomainCocktail()
                        }
                    }
                }
        }
        return test
    }
}