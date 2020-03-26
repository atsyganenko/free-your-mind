package com.free.your_mind

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.free.your_mind.data.Task

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    var data = listOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.from(parent)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}