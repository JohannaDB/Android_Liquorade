package com.example.liquorade.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CocktailDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cocktails: List<CocktailDb>)

    @Update
    fun update(cocktails: List<CocktailDb>)

    @Query("DELETE FROM cocktails")
    fun clear()

    @Query("SELECT * FROM cocktails WHERE category = :categoryName ORDER BY cocktail_name")
    fun getCocktails(categoryName: String): LiveData<List<CocktailDb>>
}

@Dao
interface CategoryDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categories: List<CategoryDb>)

    @Update
    fun update(categories: List<CategoryDb>)

    @Query("DELETE FROM categories")
    fun clear()

    @Query("SELECT * FROM categories ORDER BY category_name")
    fun getAllCategories(): LiveData<List<CategoryDb>>
}