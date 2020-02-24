package com.free.your_mind.data

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DoneTaskViewModelFactory(
    private val dataSource: TaskDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DoneTaskViewModel::class.java)) {
            return DoneTaskViewModel(dataSource, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}