package com.example.liquorade.cocktail.di

import android.content.Context
import com.example.liquorade.cocktail.CocktailViewModelFactory
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.repository.CategoryRepository
import com.example.liquorade.repository.CocktailRepository
import dagger.Module
import dagger.Provides

@Module
class CocktailModule {
    @Provides
    fun provideViewModelFactory(repository: CocktailRepository) : CocktailViewModelFactory {
        return CocktailViewModelFactory(repository)
    }

    @Provides
    fun provideRepository(database: CocktailDatabase, service: CocktailApiService, context: Context): CocktailRepository {
        return CocktailRepository(service, database.cocktailDatabaseDao, context)
    }
}