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
import com.example.liquorade.network.CocktailApi
import com.example.liquorade.network.ConnectionChecker
import kotlinx.coroutines.*


class CategoryRepository(private val categoryDao: CategoryDatabaseDao, val context: Context) {

    private var job = Job()

    private val scope = CoroutineScope(job + Dispatchers.IO)

    val connectionChecker = ConnectionChecker.Companion

    val categories = listOf("Gin", "Vodka", "Bourbon", "Light rum", "Dark rum", "Triple sec", "Brandy", "Tequila", "Dry Vermouth", "Sweet Vermouth")

    fun getCategories() : LiveData<List<CategoryDb>> {
        var test = MediatorLiveData<List<CategoryDb>>()
        scope.launch {
            try {
                if (connectionChecker.isInternetAvailable(context)) {
                    val temporaryCategoryList = CocktailApi.retrofitService.getCategories()
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
        Log.i("REPO", test.value.toString())
        return test
    }

//    fun getCat() : CategoryList {
//        var categoryList = CategoryList(ArrayList())
//        scope.launch {
//            try {
//                categoryList = CocktailApi.retrofitService.getCategories()
//            } catch (e: Exception) {
//                Log.i("AAAAAAAAAA", e.message.toString())
//            }
//        }
//        return categoryList
//    }
//
//    fun insert(list: List<Category>) : List<Category> {
//        var test = MediatorLiveData<List<CategoryDb>>()
//        scope.launch {
//            try {
//                categoryDao.insert(list.asDatabaseCategory())
//                withContext(Dispatchers.Main) {
//                    test.addSource(categoryDao.getAllCategories()) {
//                        test.removeSource(categoryDao.getAllCategories())
//                        test.value = it
//                    }
//                }
//            } catch(e: Exception) {
//                Log.i("AAAAAAAAAA", e.message.toString())
//            }
//        }
//        return test
//    }
}