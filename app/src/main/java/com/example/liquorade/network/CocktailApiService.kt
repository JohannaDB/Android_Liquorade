package com.example.liquorade.network

import com.example.liquorade.domain.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CocktailApiService {
    //Get categories
    @GET("list.php?i=list")
    suspend fun getCategories():
            CategoryList

    //Get cocktails from specific category
    @GET("filter.php?")
    suspend fun getCocktails(@Query("i") categoryName: String):
            CocktailList

    @GET("lookup.php?")
    @Annotation
    suspend fun getCocktailDetails(@Query("i") cocktailId: String):
            CocktailDetail

    @GET("search.php?")
    suspend fun getIngredientDetails(@Query("i") ingredientName: String):
            IngredientDetails

    @GET("random.php")
    @Annotation
    suspend fun getRandomCocktail():
            CocktailDetail
}
