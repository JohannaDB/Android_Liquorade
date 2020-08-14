package com.example.liquorade.network

import com.example.liquorade.domain.CategoryList
import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.domain.CocktailList
import com.example.liquorade.domain.IngredientDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApiService {
    /**
     * Returns all categories
     *
     * @return Category list
     */
    @GET("list.php?i=list")
    suspend fun getCategories():
            CategoryList

    /**
     * Returns all cocktails of a specific category
     *
     * @param categoryName The name of the category
     * @return Cocktail list
     */
    @GET("filter.php?")
    suspend fun getCocktails(@Query("i") categoryName: String):
            CocktailList

    /**
     * Returns cocktail details of a specific cocktail
     *
     * @param cocktailId The id of the cocktail
     * @return Cocktail details
     */
    @GET("lookup.php?")
    @Annotation
    suspend fun getCocktailDetails(@Query("i") cocktailId: String):
            CocktailDetail

    /**
     * Returns ingredient details of a specific ingredient
     *
     * @param ingredientName The name of the ingredient
     * @return Ingredient details
     */
    @GET("search.php?")
    suspend fun getIngredientDetails(@Query("i") ingredientName: String):
            IngredientDetails

    /**
     * Returns cocktail details of a random cocktail
     *
     * @return Cocktail details of random cocktail
     */
    @GET("random.php")
    @Annotation
    suspend fun getRandomCocktail():
            CocktailDetail
}
