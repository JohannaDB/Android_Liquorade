package com.example.liquorade.domain

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