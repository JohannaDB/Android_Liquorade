package com.example.liquorade.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CocktailDatabaseDao {
    @Insert
    fun insert(cocktail: CocktailDb)

    @Update
    fun update(cocktail: CocktailDb)

    @Query("SELECT * from cocktails WHERE idDrink = :key")
    fun getCocktail(key: String): CocktailDb?

    @Query("DELETE FROM cocktails")
    fun clear()

    @Query("SELECT * FROM cocktails ORDER BY idDrink DESC")
    fun getAllCocktails(): LiveData<List<CocktailDb>>
}