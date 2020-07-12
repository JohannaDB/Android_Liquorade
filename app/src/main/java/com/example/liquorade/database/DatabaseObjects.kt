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

@Entity(tableName = "categories")
data class CategoryDb(
    @PrimaryKey(autoGenerate = true)
    var _id: Long = 0L,
    @ColumnInfo(name = "category_name")
    val strIngredient1: String,
    val imageUrl: String = "https://www.thecocktaildb.com/images/ingredients/$strIngredient1.png"
)