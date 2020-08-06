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
    fun provideViewModelFactory(repository: IngredientDetailRepository) : IngredientDetailViewModelFactory {
        return IngredientDetailViewModelFactory(repository)
    }

    @Provides
    fun provideRepository(service: CocktailApiService): IngredientDetailRepository {
        return IngredientDetailRepository(service)
    }
}