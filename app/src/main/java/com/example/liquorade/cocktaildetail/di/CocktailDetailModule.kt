package com.example.liquorade.cocktaildetail.di

import com.example.liquorade.cocktaildetail.CocktailDetailViewModelFactory
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.repository.CocktailDetailRepository
import dagger.Module
import dagger.Provides

@Module
class CocktailDetailModule {
    @Provides
            /**
             * Explains how the CocktailDetailViewModelFactory is created
             *
             * @param repository The CocktailDetailRepository
             * @return The CocktailDetailViewModelFactory
             */
    fun provideViewModelFactory(repository: CocktailDetailRepository) : CocktailDetailViewModelFactory {
        return CocktailDetailViewModelFactory(repository)
    }

    @Provides
            /**
             * Explains how the CocktailDetailRepository is created
             *
             * @param service The CocktailApiService
             * @return The CocktailDetailRepository
             */
    fun provideRepository(service: CocktailApiService): CocktailDetailRepository {
        return CocktailDetailRepository(service)
    }
}