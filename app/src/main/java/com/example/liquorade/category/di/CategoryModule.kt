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
            /**
             * Explains how the CategoryViewModelFactory is created
             *
             * @param repository The CategoryRepository
             * @return The CategoryViewModelFactory
             */
    fun provideViewModelFactory(repository: CategoryRepository) : CategoryViewModelFactory {
        return CategoryViewModelFactory(repository)
    }

    @Provides
            /**
             * Explains how the CategoryRepository is created
             *
             * @param database The CocktailDatabase
             * @param service The CocktailApiService
             * @param connectionChecker The ConnectionChecker
             * @return The CategoryRepository
             */
    fun provideRepository(database: CocktailDatabase, service: CocktailApiService, connectionChecker: ConnectionChecker): CategoryRepository {
        return CategoryRepository(service, database.categoryDatabaseDao, connectionChecker)
    }
}