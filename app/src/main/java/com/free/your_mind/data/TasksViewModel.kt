package com.free.your_mind.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.*

class TasksViewModel(application: Application) : AndroidViewModel(application) {

    private val database = TaskDatabase.getInstance(application).taskDatabaseDao
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var tasks = database.getAllTasks()

    fun markTaskAsDone(taskId: Int) {

        val taskToUpdate = tasks.value!!.find { it.id == taskId }
        uiScope.launch {
            withContext(Dispatchers.IO) {
                taskToUpdate?.let { database.updateTask(it.copy(done = true)) }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


}