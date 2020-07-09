package com.example.liquorade.network

import com.example.liquorade.domain.Category
import com.example.liquorade.domain.CocktailList
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(OkHttpClient.Builder().build())
        .build()

interface CocktailApiService {
    //Get Gin information
    @GET("search.php?i=Gin")
    suspend fun getGinInformation():
            Category

    //Get Gin cocktails
    @GET("filter.php?i=Gin")
    suspend fun getGinDrinks():
            CocktailList

    //Get Vodka cocktails
    @GET("filter.php?i=Vodka")
    suspend fun getVodkaDrinks():
            CocktailList

    //Get Bourbon cocktails
    @GET("filter.php?i=Bourbon")
    suspend fun getBourbonDrinks():
            CocktailList

    //Get Light Rum cocktails
    @GET("filter.php?i=Light_Rum")
    suspend fun getLightRumDrinks():
            CocktailList

    //Get Dark Rum cocktails
    @GET("filter.php?i=Dark_Rum")
    suspend fun getDarkRumDrinks():
            CocktailList

    //Get Triple Sec cocktails
    @GET("filter.php?i=Triple_Sed")
    suspend fun getTripleSecDrinks():
            CocktailList

    //Get Brandy cocktails
    @GET("filter.php?i=Brandy")
    suspend fun getBrandyDrinks():
            CocktailList

    //Get Tequila cocktails
    @GET("filter.php?i=Tequila")
    suspend fun getTequilaDrinks():
            CocktailList

    //Get Dry Vermouth cocktails
    @GET("filter.php?i=Dry_Vermouth")
    suspend fun getDryVermouthDrinks():
            CocktailList

    //Get Sweet Vermouth cocktails
    @GET("filter.php?i=Sweet_Vermouth")
    suspend fun getSweetVermouthDrinks():
            CocktailList
}

object CocktailApi {
    val retrofitService : CocktailApiService by lazy {
        retrofit.create(CocktailApiService::class.java)
    }
}