package com.example.liquorade.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.liquorade.domain.Category
import com.example.liquorade.domain.Cocktail

@Entity(tableName = "cocktails")
data class CocktailDb(
    @PrimaryKey
    var idDrink: String = "",
    @ColumnInfo(name = "cocktail_name")
    val strDrink: String,
    @ColumnInfo(name = "cocktail_image")
    val strDrinkThumb: String,
    @ColumnInfo(name = "category")
    val categoryName: String
)

fun List<CocktailDb>.asDomainCocktail(): List<Cocktail> {
    return map {
        Cocktail(
            idDrink = it.idDrink,
            strDrink = it.strDrink,
            strDrinkThumb = it.strDrinkThumb)
    }
}

fun List<CocktailDb>.updateCategoryName(categoryName: String): List<CocktailDb> {
    return map {
        CocktailDb(
            idDrink = it.idDrink,
            strDrink = it.strDrink,
            strDrinkThumb = it.strDrinkThumb,
            categoryName = categoryName)
    }
}

@Entity(tableName = "categories")
data class CategoryDb(
    @PrimaryKey
    @ColumnInfo(name = "category_name")
    val strIngredient1: String,
    val imageUrl: String = "https://www.thecocktaildb.com/images/ingredients/$strIngredient1.png"
)

fun List<CategoryDb>.asDomainCategory(): List<Category> {
    return map {
        Category(
            strIngredient1 = it.strIngredient1,
            imageUrl = it.imageUrl)
    }
}