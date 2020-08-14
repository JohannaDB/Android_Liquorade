package com.example.liquorade.domain

import com.example.liquorade.database.CocktailDb

data class CocktailList(
    val drinks: List<Cocktail>
)

data class Cocktail(
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String,
    val categoryName: String = ""
)

data class CocktailDetail(
    val idDrink: Int,
    val strDrink: String,
    val strDrinkThumb: String,
    val strTags: String? = "",
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String,
    val strInstructions: String,
    val ingredients: Map<String?, String?>
)

data class CocktailDetails(
    val drinks: List<CocktailDetailNetwork>
)

data class CocktailDetailNetwork(
    val idDrink: Int,
    val strDrink: String,
    val strDrinkThumb: String,
    val strTags: String? = "",
    val strCategory: String,
    val strAlcoholic: String,
    val strGlass: String,
    val strInstructions: String,
    val strIngredient1: String? = "",
    val strIngredient2: String? = "",
    val strIngredient3: String? = "",
    val strIngredient4: String? = "",
    val strIngredient5: String? = "",
    val strIngredient6: String? = "",
    val strIngredient7: String? = "",
    val strIngredient8: String? = "",
    val strIngredient9: String? = "",
    val strIngredient10: String? = "",
    val strIngredient11: String? = "",
    val strIngredient12: String? = "",
    val strIngredient13: String? = "",
    val strIngredient14: String? = "",
    val strIngredient15: String? = "",
    val strMeasure1: String? = "",
    val strMeasure2: String? = "",
    val strMeasure3: String? = "",
    val strMeasure4: String? = "",
    val strMeasure5: String? = "",
    val strMeasure6: String? = "",
    val strMeasure7: String? = "",
    val strMeasure8: String? = "",
    val strMeasure9: String? = "",
    val strMeasure10: String? = "",
    val strMeasure11: String? = "",
    val strMeasure12: String? = "",
    val strMeasure13: String? = "",
    val strMeasure14: String? = "",
    val strMeasure15: String? = ""
)

/**
 * Maps a list of cocktails to a list of database cocktails
 *
 * @return List of database cocktails
 */
fun List<Cocktail>.asDatabaseCocktail(categoryName: String): List<CocktailDb> {
    return map {
        CocktailDb(
            idDrink = it.idDrink,
            strDrink = it.strDrink,
            strDrinkThumb = it.strDrinkThumb,
            categoryName = categoryName)
    }
}