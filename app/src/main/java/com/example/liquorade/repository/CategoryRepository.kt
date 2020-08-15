package com.example.liquorade.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.database.CategoryDatabaseDao
import com.example.liquorade.database.asDomainCategory
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.asDatabaseCategory
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val service: CocktailApiService,
    private val categoryDao: CategoryDatabaseDao,
    private val connectionChecker: ConnectionChecker
) {
    private var job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    val categories = listOf("Bourbon", "Brandy", "Dark rum", "Dry Vermouth", "Gin", "Light rum", "Sweet Vermouth", "Tequila", "Triple sec", "Vodka")

    /**
     * Gets a list of categories from the back-end or from the local database, depending on the internet status
     * Unnecessary categories are filtered out of the back-end
     *
     * @return LiveData list of categories
     */
    fun getCategories(): LiveData<List<Category>> {
        val categoryData = MediatorLiveData<List<Category>>()
        scope.launch {
            if (connectionChecker.isInternetAvailable()) {
                val temporaryCategoryList = service.getCategories()
                val categoryList = ArrayList<Category>()
                temporaryCategoryList.drinks.forEach { category ->
                    if (categories.contains(category.strIngredient1)) {
                        categoryList.add(category)
                    }
                }
                val sortedList = categoryList.sortedWith(compareBy { it.strIngredient1 })
                categoryDao.insert(sortedList.asDatabaseCategory())
                withContext(Dispatchers.Main) {
                    categoryData.value = sortedList
                }
            } else {
                withContext(Dispatchers.Main) {
                    categoryData.addSource(categoryDao.getAllCategories()) {
                        categoryData.removeSource(categoryDao.getAllCategories())
                        categoryData.value = it.asDomainCategory()
                    }
                }
            }
        }
        return categoryData
    }
}
