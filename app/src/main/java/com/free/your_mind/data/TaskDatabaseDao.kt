package com.free.your_mind.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDatabaseDao {

    @Insert
    fun insert(task: DoneTask)

    @Query("SELECT * FROM done_free_mind_challenges")
    fun getAllDoneTasks(): List<DoneTask>

}