package com.free.your_mind

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.free.your_mind.data.Task

class TaskAdapter(val clickListener: TaskClickListener) : ListAdapter<Task, TaskViewHolder>(TaskCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
}