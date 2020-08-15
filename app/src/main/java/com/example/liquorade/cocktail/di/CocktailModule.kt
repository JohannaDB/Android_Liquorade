package com.example.liquorade.cocktail.di

import com.example.liquorade.cocktail.CocktailViewModelFactory
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import com.example.liquorade.repository.CocktailRepository
import dagger.Module
import dagger.Provides

@Module
class CocktailModule {
    @Provides
    /**
     * Explains how the CocktailViewModelFactory is created
     *
     * @param repository The CocktailRepository
     * @return The CocktailViewModelFactory
     */
    fun provideViewModelFactory(repository: CocktailRepository): CocktailViewModelFactory {
        return CocktailViewModelFactory(repository)
    }

    @Provides
    /**
     * Explains how the CocktailRepository is created
     *
     * @param database The CocktailDatabase
     * @param service The CocktailApiService
     * @param connectionChecker The ConnectionChecker
     * @return The CocktailRepository
     */
    fun provideRepository(database: CocktailDatabase, service: CocktailApiService, connectionChecker: ConnectionChecker): CocktailRepository {
        return CocktailRepository(service, database.cocktailDatabaseDao, connectionChecker)
    }
}
