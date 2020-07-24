package com.example.liquorade.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CocktailDb::class, CategoryDb::class], version = 1,  exportSchema = false)
abstract class CocktailDatabase : RoomDatabase() {

    abstract val cocktailDatabaseDao: CocktailDatabaseDao
    abstract val categoryDatabaseDao: CategoryDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: CocktailDatabase? = null

        fun getInstance(context: Context): CocktailDatabase {
            //database will only get initialized once
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CocktailDatabase::class.java,
                        "cocktail_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}