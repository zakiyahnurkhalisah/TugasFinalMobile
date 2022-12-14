package com.D121201021.task.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    val readAllData:LiveData<List<Task>>
    private val repository: TaskRepository

    init {
        val userDao = TaskDatabase.getDatabase(application).userDao()
        repository = TaskRepository(userDao)
        readAllData = repository.readAllData

    }

    fun addUser(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(task)
        }
    }
}