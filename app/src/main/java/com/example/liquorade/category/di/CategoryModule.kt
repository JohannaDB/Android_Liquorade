package com.example.liquorade.category.di

import android.content.Context
import com.example.liquorade.category.CategoryViewModelFactory
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.network.CocktailApiService
import com.example.liquorade.network.ConnectionChecker
import com.example.liquorade.repository.CategoryRepository
import dagger.Module
import dagger.Provides

@Module
class CategoryModule {
    @Provides
    fun provideViewModelFactory(repository: CategoryRepository) : CategoryViewModelFactory {
        return CategoryViewModelFactory(repository)
    }

    @Provides
    fun provideRepository(database: CocktailDatabase, service: CocktailApiService, connectionChecker: ConnectionChecker): CategoryRepository {
        return CategoryRepository(service, database.categoryDatabaseDao, connectionChecker)
    }
}