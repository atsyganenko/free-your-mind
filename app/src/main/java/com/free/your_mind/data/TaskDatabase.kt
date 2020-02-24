package com.free.your_mind.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [DoneTask::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDatabaseDao: TaskDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "done_tasks_database"
                    ).fallbackToDestructiveMigration().build()
                }
                INSTANCE = instance
                return instance
            }

        }
    }

}