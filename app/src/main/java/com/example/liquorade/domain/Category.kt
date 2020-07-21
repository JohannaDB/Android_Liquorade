package com.example.liquorade.domain

import com.example.liquorade.database.CategoryDb

data class CategoryList(
    val drinks: List<Category>
)

data class Category(
    val strIngredient1: String,
    val imageUrl: String = "https://www.thecocktaildb.com/images/ingredients/$strIngredient1.png"
)

//data class CategoryInformation(
//    val idIngredient: String,
//    val strIngredient: String,
//    val strDescription: String,
//    val imageUrl: String = "https://www.thecocktaildb.com/images/ingredients/$strIngredient.png"
//)

fun List<Category>.asDatabaseCategory(): List<CategoryDb> {
    return map {
        CategoryDb(
            strIngredient1 = it.strIngredient1,
            imageUrl = it.imageUrl)
    }
}