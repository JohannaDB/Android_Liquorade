package com.example.liquorade.domain

import com.example.liquorade.database.CategoryDb

data class CategoryList(
    val drinks: List<Category>
)

data class Category(
    val strIngredient1: String,
    val imageUrl: String = "https://www.thecocktaildb.com/images/ingredients/$strIngredient1.png"
)

/**
 * Maps a list of categories to a list of database categories
 *
 * @return List of database categories
 */
fun List<Category>.asDatabaseCategory(): List<CategoryDb> {
    return map {
        CategoryDb(
            strIngredient1 = it.strIngredient1,
            imageUrl = it.imageUrl
        )
    }
}
