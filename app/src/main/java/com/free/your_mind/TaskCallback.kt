package com.free.your_mind

import androidx.recyclerview.widget.DiffUtil
import com.free.your_mind.data.Task

class TaskCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
       return oldItem.id == newItem.id
    }
}