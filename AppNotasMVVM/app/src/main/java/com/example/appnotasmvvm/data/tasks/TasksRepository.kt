package com.example.appnotasmvvm.data.tasks

import com.example.appnotasmvvm.data.tasks.local.TaskDao
import com.example.appnotasmvvm.data.tasks.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TasksRepository @Inject constructor(
    private val taskDao : TaskDao
) {
    fun getAllTaskCompled(finalized : Boolean): Flow<List<TaskEntity>>{
        return taskDao.getAllCompleted(finalized)
    }

    suspend fun insertTask(taskEntity: TaskEntity){
        taskDao.insert(taskEntity)
    }

    suspend fun updateTask(taskEntity: TaskEntity){
        taskDao.update(taskEntity)
    }

    suspend fun deleteTask(taskEntity: TaskEntity){
        taskDao.delete(taskEntity)
    }
}