package com.example.liquorade

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.liquorade.database.CategoryDatabaseDao
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.database.CocktailDatabaseDao
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.Cocktail
import com.example.liquorade.domain.asDatabaseCategory
import com.example.liquorade.domain.asDatabaseCocktail
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    // Needed to attach observer to LiveData
    @get: Rule
    val instantExecution = InstantTaskExecutorRule()
    private lateinit var database: CocktailDatabase
    private lateinit var cocktailDao: CocktailDatabaseDao
    private lateinit var categoryDao: CategoryDatabaseDao

    private val testCocktails: List<Cocktail> = listOf(
        Cocktail(idDrink = "1", strDrink = "TestCocktail", strDrinkThumb = "TestUrl"),
        Cocktail(idDrink = "2", strDrink = "TestCocktail2", strDrinkThumb = "TestUrl2")
    )

    private val testCategories: List<Category> = listOf(
        Category(strIngredient1 = "Gin"),
        Category(strIngredient1 = "Rum"),
        Category(strIngredient1 = "Vodka")
    )

    @Before
    fun createDatabase() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        database = Room.inMemoryDatabaseBuilder(context, CocktailDatabase::class.java)
            .allowMainThreadQueries().build()
        cocktailDao = database.cocktailDatabaseDao
        categoryDao = database.categoryDatabaseDao
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        database.close()
    }

    @Test
    @Throws(IOException::class)
    fun insertCocktails() {
        cocktailDao.insert(testCocktails.asDatabaseCocktail(""))
        val result = cocktailDao.getCocktails("").getLiveDataValue().asDomainCocktail()
        Assert.assertEquals(testCocktails, result)
    }

    @Test
    @Throws(IOException::class)
    fun insertCategories() {
        categoryDao.insert(testCategories.asDatabaseCategory())
        val result = categoryDao.getAllCategories().getLiveDataValue().asDomainCategory()
        Assert.assertEquals(testCategories, result)
    }
}

// Attach observer to LiveData to fetch its values
fun <T> LiveData<T>.getLiveDataValue(time: Long = 2, timeUnit: TimeUnit = TimeUnit.SECONDS): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(t: T) {
            data = t
            latch.countDown()
            this@getLiveDataValue.removeObserver(this)
        }
    }
    observeForever(observer)
    if (!latch.await(time, timeUnit)) {
        throw TimeoutException("Value never set")
    }
    return data as T
}
