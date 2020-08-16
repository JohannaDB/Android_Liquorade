package com.example.liquorade.repository

import com.example.liquorade.database.CategoryDatabaseDao
import com.example.liquorade.database.asDomainCategory
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.asDatabaseCategory
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val service: CocktailApiService,
    private val categoryDao: CategoryDatabaseDao,
    private val connectionChecker: ConnectionChecker
) {
    val categories = listOf(
        "Bourbon",
        "Brandy",
        "Dark rum",
        "Dry Vermouth",
        "Gin",
        "Light rum",
        "Sweet Vermouth",
        "Tequila",
        "Triple sec",
        "Vodka"
    )

    /**
     * Gets a list of categories from the back-end or from the local database, depending on the internet status
     * Unnecessary categories are filtered out of the back-end
     *
     * @return List of categories
     */
    suspend fun getCategories(): List<Category> {
        val categoryList: List<Category>
        withContext(Dispatchers.IO) {
            if (connectionChecker.isInternetAvailable()) {
                val internetCategories = service.getCategories()
                val filteredCategories = internetCategories.drinks.filter { category ->
                    categories.contains(category.strIngredient1)
                }
                val sortedList = filteredCategories.sortedWith(compareBy { it.strIngredient1 })
                categoryDao.insert(sortedList.asDatabaseCategory())
                categoryList = sortedList
            } else {
                categoryList = categoryDao.getAllCategories().asDomainCategory()
            }
        }
        return categoryList
    }
}
