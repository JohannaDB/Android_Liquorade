package com.example.liquorade.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktails")
data class CocktailDb(
    @PrimaryKey
    var idDrink: String = "",
    @ColumnInfo(name = "cocktail_name")
    val strDrink: String,
    @ColumnInfo(name = "cocktail_image")
    val strDrinkThumb: String
)