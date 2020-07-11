package com.example.liquorade.network

import com.example.liquorade.domain.CategoryList
import com.example.liquorade.domain.CocktailList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().build())
        .build()

interface CocktailApiService {
    //Get categories
    @GET("list.php?i=list")
    suspend fun getCategories():
            CategoryList

    //Get cocktails from specific category
    @GET("filter.php?")
    suspend fun getCocktails(@Query("i") categoryName : String):
            CocktailList
}

object CocktailApi {
    val retrofitService : CocktailApiService by lazy {
        retrofit.create(CocktailApiService::class.java)
    }
}