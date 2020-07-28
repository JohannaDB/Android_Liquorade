package com.example.liquorade.network

import com.example.liquorade.domain.CategoryList
import com.example.liquorade.domain.CocktailDetails
import com.example.liquorade.domain.CocktailList
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
    suspend fun getCocktailDetails(@Query("i") cocktailId: String):
            CocktailDetails
}
