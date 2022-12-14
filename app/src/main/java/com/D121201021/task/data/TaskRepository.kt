package com.D121201021.task.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {

    val readAllData: LiveData<List<Task>> = taskDao.readAllData()

    suspend fun addUser(task: Task){
        taskDao.addUser(task)
    }
}