package com.example.liquorade.repository

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.liquorade.database.CategoryDatabaseDao
import com.example.liquorade.database.CategoryDb
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.asDatabaseCategory
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*
import javax.inject.Inject


class CategoryRepository @Inject constructor(
    private val service: CocktailApiService,
    private val categoryDao: CategoryDatabaseDao,
    private val connectionChecker: ConnectionChecker
) {

    private var job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    val categories = listOf("Gin", "Vodka", "Bourbon", "Light rum", "Dark rum", "Triple sec", "Brandy", "Tequila", "Dry Vermouth", "Sweet Vermouth")

    fun getCategories() : LiveData<List<CategoryDb>> {
        var test = MediatorLiveData<List<CategoryDb>>()
        scope.launch {
            try {
                if (connectionChecker.isInternetAvailable()) {
                    val temporaryCategoryList = service.getCategories()
                    val categoryList = ArrayList<Category>()
                    temporaryCategoryList.drinks.forEach { category ->
                        if(categories.contains(category.strIngredient1)) {
                            categoryList.add(category)
                        }
                    }
                    categoryDao.insert(categoryList.asDatabaseCategory())
                    withContext(Dispatchers.Main) {
                        test.value = categoryList.asDatabaseCategory()
                    }
                } else {
                    withContext(Dispatchers.Main){
                        test.addSource(categoryDao.getAllCategories()){
                            test.removeSource(categoryDao.getAllCategories())
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