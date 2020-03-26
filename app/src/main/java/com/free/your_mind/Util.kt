package com.free.your_mind

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.free.your_mind.data.Task

class TaskViewHolder private constructor(val textView: TextView) :
    RecyclerView.ViewHolder(textView) {
    fun bind(item: Task) {
        textView.text = item.toString()
        textView.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(
                    TasksFragmentDirections.actionTasksFragmentToTaskDetailsFragment(
                        item.id
                    )
                )
        }
    }

    companion object {
        fun from(parent: ViewGroup): TaskViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater
                .inflate(R.layout.text_item_view, parent, false) as TextView
            return TaskViewHolder(view)
        }
    }
}