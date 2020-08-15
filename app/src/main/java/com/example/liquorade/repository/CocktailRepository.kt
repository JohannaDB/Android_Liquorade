package com.example.liquorade.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.database.asDomainCocktail
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.domain.asDatabaseCocktail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    fun getCocktails(categoryName: String): LiveData<List<Cocktail>> {
        var cocktailData = MediatorLiveData<List<Cocktail>>()
        scope.launch {
            if (connectionChecker.isInternetAvailable()) {
                val cocktailList = service.getCocktails(categoryName)
                cocktailDao.insert(cocktailList.drinks.asDatabaseCocktail(categoryName))
                withContext(Dispatchers.Main) {
                    cocktailData.value = cocktailList.drinks
                }
            } else {
                withContext(Dispatchers.Main) {
                    cocktailData.addSource(cocktailDao.getCocktails(categoryName)) {
                        cocktailData.removeSource(cocktailDao.getCocktails(categoryName))
                        cocktailData.value = it.asDomainCocktail()
                    }
                }
            }
        }
        return cocktailData
    }
}
