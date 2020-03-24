package com.free.your_mind.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.*

class DoneTaskViewModel(application: Application) : AndroidViewModel(application) {

    private val database = TaskDatabase.getInstance(application).taskDatabaseDao
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var doneTaskIds = database.doneTaskIds()

    fun markTaskAsDone(taskId: Int) {
        if (!doneTaskIds.value!!.contains(taskId)) {
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


}