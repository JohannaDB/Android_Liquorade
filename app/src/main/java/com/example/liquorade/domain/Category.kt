package com.example.liquorade.domain

data class Category(
    val ingredients: List<CategoryInformation>
)

data class CategoryInformation(
    val idIngredient: String,
    val strIngredient: String,
    val strDescription: String,
    val imageUrl: String = "https://www.thecocktaildb.com/images/ingredients/$strIngredient.png"
)