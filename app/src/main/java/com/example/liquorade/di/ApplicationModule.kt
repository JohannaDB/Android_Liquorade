package com.example.liquorade.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.room.Room
import com.example.liquorade.database.CocktailDatabase
import com.example.liquorade.network.ConnectionChecker
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {
    @Provides
            /**
             * Explains how the database should be created
             *
             * @param context Context, current state of the application
             * @return Cocktail Database
             */
    fun provideDatabase(context: Context): CocktailDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CocktailDatabase::class.java,
            "cocktail_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
            /**
             * Explains how the ConnectivityManager is created
             *
             * @param context Context, current state of the application
             * @return ConnectivityManager
             */
    fun provideConnectivityManager(context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    @Provides
            /**
             * Explains how the connectionChecker is created
             *
             * @param connectivityManager ConnectivityManager
             * @return ConnectionChecker
             */
    fun provideConnectionChecker(connectivityManager: ConnectivityManager): ConnectionChecker {
        return ConnectionChecker(connectivityManager)
    }
}