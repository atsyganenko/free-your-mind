package com.free.your_mind

import com.free.your_mind.data.Task

class TaskClickListener(val clickListener: (taskId: Int) -> Unit) {

    fun onClick(task: Task) = clickListener(task.id)
}