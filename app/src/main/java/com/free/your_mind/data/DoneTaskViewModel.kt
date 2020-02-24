package com.free.your_mind.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class DoneTaskViewModel(
    val database: TaskDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var _doneTasks = MutableLiveData<Set<Int>>()

    val doneTasks: LiveData<Set<Int>>
        get() = _doneTasks

    init {
        initDoneTasks()
    }

    fun markTaskAsDone(taskId: Int) {
        if (doneTasks.value == null || !doneTasks.value!!.contains(taskId)) {
            uiScope.launch {
                withContext(Dispatchers.IO) {
                    database.insert(DoneTask(taskId))
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private fun initDoneTasks() {
        uiScope.launch {
            _doneTasks.value = queryDoneTasksFromDatabase()

        }
    }

    private suspend fun queryDoneTasksFromDatabase(): Set<Int> {
        return withContext(Dispatchers.IO) {
            database.getAllDoneTasks().map { task -> task.taskId }.toSet()
        }

    }

}