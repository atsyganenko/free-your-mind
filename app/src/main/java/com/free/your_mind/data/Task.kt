package com.free.your_mind.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "free_mind_tasks")
data class Task(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val image: String? = null,
    val done: Boolean = false
)
