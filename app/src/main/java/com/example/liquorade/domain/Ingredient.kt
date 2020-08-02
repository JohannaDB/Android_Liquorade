package com.example.liquorade.domain

data class IngredientDetails(
    val ingredients: List<IngredientDetail>
)

data class IngredientDetail(
    val idIngredient: String,
    val strIngredient: String,
    val strDescription: String,
    val imageUrl: String = "https://www.thecocktaildb.com/images/ingredients/$strIngredient.png"
)