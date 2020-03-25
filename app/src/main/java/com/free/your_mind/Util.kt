package com.free.your_mind

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewHolder private constructor(val textView: TextView) :
    RecyclerView.ViewHolder(textView) {
    fun bind(item: Int) {
        textView.text = item.toString()
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