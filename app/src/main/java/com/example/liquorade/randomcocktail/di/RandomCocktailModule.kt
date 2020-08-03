package com.example.liquorade.randomcocktail.di

import com.example.liquorade.ingredientdetail.IngredientDetailViewModelFactory
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import com.example.liquorade.randomcocktail.RandomCocktailViewModelFactory
import com.example.liquorade.repository.IngredientDetailRepository
import com.example.liquorade.repository.RandomCocktailRepository
import dagger.Module
import dagger.Provides

@Module
class RandomCocktailModule{
    @Provides
    fun provideViewModelFactory(repository: RandomCocktailRepository) : RandomCocktailViewModelFactory {
        return RandomCocktailViewModelFactory(repository)
    }

    @Provides
    fun provideRepository(service: CocktailApiService): RandomCocktailRepository {
        return RandomCocktailRepository(service)
    }
}