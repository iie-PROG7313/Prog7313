package com.fake.starsuck

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context


@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: android.content.Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "starsucks_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
