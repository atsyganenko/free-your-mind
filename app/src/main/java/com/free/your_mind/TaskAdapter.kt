package com.free.your_mind

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {

    var data =  listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TaskViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.toString()
    }
}