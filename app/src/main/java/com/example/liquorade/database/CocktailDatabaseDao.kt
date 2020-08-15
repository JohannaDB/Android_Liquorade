package com.example.liquorade.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CocktailDatabaseDao {
    /**
     * Inserts a list of cocktails into the database
     *
     * @param cocktails is a list of database cocktails
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(cocktails: List<CocktailDb>)

    /**
     * Returns all cocktails from a specific category stored in the database
     *
     * @param categoryName is the specified category name of the cocktails
     * @return All cocktails from a specific category stored in the database
     */
    @Query("SELECT * FROM cocktails WHERE category = :categoryName ORDER BY cocktail_name")
    fun getCocktails(categoryName: String): LiveData<List<CocktailDb>>
}

@Dao
interface CategoryDatabaseDao {
    /**
     * Inserts a list of categories into the database
     *
     * @param categories is a list of database categories
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categories: List<CategoryDb>)

    /**
     * Returns all categories stored in the database
     *
     * @return All categories stored in the database
     */
    @Query("SELECT * FROM categories ORDER BY category_name")
    fun getAllCategories(): LiveData<List<CategoryDb>>
}
