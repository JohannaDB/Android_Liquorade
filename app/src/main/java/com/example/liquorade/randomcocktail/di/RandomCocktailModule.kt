package com.example.liquorade.randomcocktail.di

import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.randomcocktail.RandomCocktailViewModelFactory
import com.example.liquorade.repository.RandomCocktailRepository
import dagger.Module
import dagger.Provides

@Module
class RandomCocktailModule {
    @Provides
    /**
     * Explains how the RandomCocktailViewModelFactory is created
     *
     * @param repository The RandomCocktailRepository
     * @return The RandomCocktailViewModelFactory
     */
    fun provideViewModelFactory(repository: RandomCocktailRepository): RandomCocktailViewModelFactory {
        return RandomCocktailViewModelFactory(repository)
    }

    @Provides
    /**
     * Explains how the RandomCocktailRepository is created
     *
     * @param service The CocktailApiService
     * @return The RandomCocktailRepository
     */
    fun provideRepository(service: CocktailApiService): RandomCocktailRepository {
        return RandomCocktailRepository(service)
    }
}
