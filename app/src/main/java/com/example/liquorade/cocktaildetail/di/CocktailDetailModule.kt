package com.example.liquorade.cocktaildetail.di

import com.example.liquorade.cocktaildetail.CocktailDetailViewModelFactory
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import com.example.liquorade.repository.CocktailDetailRepository
import dagger.Module
import dagger.Provides

@Module
class CocktailDetailModule {
    @Provides
    fun provideViewModelFactory(repository: CocktailDetailRepository) : CocktailDetailViewModelFactory {
        return CocktailDetailViewModelFactory(repository)
    }

    @Provides
    fun provideRepository(service: CocktailApiService, connectionChecker: ConnectionChecker): CocktailDetailRepository {
        return CocktailDetailRepository(service, connectionChecker)
    }
}