package com.example.liquorade.ingredientdetail.di

import com.example.liquorade.ingredientdetail.IngredientDetailViewModelFactory
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import com.example.liquorade.repository.CocktailDetailRepository
import com.example.liquorade.repository.IngredientDetailRepository
import dagger.Module
import dagger.Provides

@Module
class IngredientDetailModule {
    @Provides
            /**
             * Explains how the IngredientDetailViewModelFactory is created
             *
             * @param repository The IngredientDetailRepository
             * @return The IngredientDetailViewModelFactory
             */
    fun provideViewModelFactory(repository: IngredientDetailRepository) : IngredientDetailViewModelFactory {
        return IngredientDetailViewModelFactory(repository)
    }

    @Provides
            /**
             * Explains how the IngredientDetailRepository is created
             *
             * @param service The CocktailApiService
             * @return The IngredientDetailRepository
             */
    fun provideRepository(service: CocktailApiService): IngredientDetailRepository {
        return IngredientDetailRepository(service)
    }
}