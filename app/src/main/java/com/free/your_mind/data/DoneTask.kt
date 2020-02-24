package com.free.your_mind.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "done_free_mind_challenges")
data class DoneTask(@PrimaryKey val taskId: Int)
