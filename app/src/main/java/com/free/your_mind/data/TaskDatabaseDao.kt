package com.free.your_mind.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDatabaseDao {

    @Insert
    fun insert(task: Task)

    @Insert
    fun insertAll(tasks: List<Task>)

    @Query("SELECT * FROM free_mind_tasks")
    fun getAllTasks(): LiveData<List<Task>>

    @Update
    fun updateTask(tas: Task)

}