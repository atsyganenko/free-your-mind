package com.free.your_mind.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Task::class], version = 2, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract val taskDatabaseDao: TaskDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = buildDatabase(context)
                }
                INSTANCE = instance
                return instance
            }

        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TaskDatabase::class.java,
            "tasks_database"
        ).addCallback(object : Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Executors.ioThread {
                    getInstance(context).taskDatabaseDao.insertAll(data)
                }
            }

        }).fallbackToDestructiveMigration().build()

        private val data = listOf(
            Task(1, "Draw a pic", "It should be fun"),
            Task(2, "Write hokku", "You cna do it"),
            Task(3, "Maybe sport", "Let's move a little")
        )
    }
}

