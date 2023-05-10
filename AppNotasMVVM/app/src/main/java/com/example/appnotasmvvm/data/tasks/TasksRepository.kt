package com.example.appnotasmvvm.data.tasks

import com.example.appnotasmvvm.data.tasks.local.TaskDao
import com.example.appnotasmvvm.data.tasks.model.TaskEntity
import javax.inject.Inject

class TasksRepository @Inject constructor(
    private val taskDao : TaskDao
) {
    fun getAllTasks(): List<TaskEntity>{
        return taskDao.getAll()
    }

    fun insertTask(taskEntity: TaskEntity){
        taskDao.insert(taskEntity)
    }

    fun updateTask(taskEntity: TaskEntity){
        taskDao.update(taskEntity)
    }

    fun deleteTask(taskEntity: TaskEntity){
        taskDao.delete(taskEntity)
    }
}