package com.example.liquorade.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.room.Room
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.network.ConnectionChecker
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
    fun provideDatabase(context: Context): CocktailDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CocktailDatabase::class.java,
            "cocktail_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
    fun provideConnectionChecker(connectivityManager: ConnectivityManager): ConnectionChecker {
        return ConnectionChecker(connectivityManager)
    }
}