package com.example.liquorade.di

import android.content.Context
import androidx.room.Room
import com.example.liquorade.database.CocktailDatabase
import dagger.Module
import dagger.Provides

@Module
object ApplicationModule {
   @Provides
   fun provideDatabase(context: Context): CocktailDatabase {
       return Room.databaseBuilder(context.applicationContext, CocktailDatabase::class.java, "cocktail_database").fallbackToDestructiveMigration().build()
   }
}