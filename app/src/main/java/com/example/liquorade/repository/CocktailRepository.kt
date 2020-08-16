package com.example.liquorade.repository

import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.database.asDomainCocktail
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.domain.asDatabaseCocktail
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val service: CocktailApiService,
    private val cocktailDao: CocktailDatabaseDao,
    private val connectionChecker: ConnectionChecker
) {
    /**
     * Gets a list of cocktails from the back-end or from the local database, depending on the internet status
     *
     * @param categoryName is the specified category name of the cocktails
     * @return List of cocktails
     */
    suspend fun getCocktails(categoryName: String): List<Cocktail> {
        val cocktailList: List<Cocktail>
        withContext(Dispatchers.IO) {
            if (connectionChecker.isInternetAvailable()) {
                val cocktails = service.getCocktails(categoryName)
                cocktailDao.insert(cocktails.drinks.asDatabaseCocktail(categoryName))
                cocktailList = cocktails.drinks
            } else {
                cocktailList = cocktailDao.getCocktails(categoryName).asDomainCocktail()
            }
        }
        return cocktailList
    }
}
