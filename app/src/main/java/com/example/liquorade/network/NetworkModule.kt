package com.example.liquorade.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"

@Module
class NetworkModule {
    @Provides
    /**
     * Explains how Retrofit is created
     *
     * @param okHttpClient OkHttpClient, used for HTTP calls
     * @param moshi Moshi instance
     * @return Retrofit
     */
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    /**
     * Explains how the HttpClient is created
     *
     * @return OkHttpClient
     */
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    /**
     * Explains how Moshi is created, Moshi makes it easy to parse JSON to data objects
     *
     * @return Moshi
     */
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(DetailAdapter()).add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    /**
     * Explains how the CocktailApiService is created
     *
     * @param retrofit Retrofit http client
     * @return The CocktailApiService
     */
    fun provideService(retrofit: Retrofit): CocktailApiService {
        return retrofit.create(CocktailApiService::class.java)
    }
}
