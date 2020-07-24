package com.example.liquorade.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CocktailDb::class, CategoryDb::class], version = 1,  exportSchema = false)
abstract class CocktailDatabase : RoomDatabase() {
    abstract val cocktailDatabaseDao: CocktailDatabaseDao
    abstract val categoryDatabaseDao: CategoryDatabaseDao
}