package com.example.sethportfolio.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sethportfolio.data.database.entity.Table

@Database(entities = [Table::class],version = 1)
abstract class DB:RoomDatabase() {

    abstract fun Dao():DataAccessObject

    companion object {
        @Volatile
        private var instance: DB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK) {
            instance?: createDatabase(context).also {
                instance = it
            }

        }

        fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, DB::class.java, "DB").allowMainThreadQueries().build()
    }
}