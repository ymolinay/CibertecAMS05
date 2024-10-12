package com.cibertec.myciberapps05

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Task::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

     companion object {

         @Volatile
         private var INSTANCE: MyDatabase? = null

         fun getDatabase(context: Context): MyDatabase {
             return INSTANCE ?: synchronized(this) {
                 val instanceTmp = Room.databaseBuilder(
                     context.applicationContext,
                     MyDatabase::class.java,
                     "my_database"
                 ).allowMainThreadQueries()
                     .build()


                 INSTANCE = instanceTmp
                 instanceTmp
             }
         }

     }

}