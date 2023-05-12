package com.example.appnotasmvvm.domain.tasks

import com.example.appnotasmvvm.data.tasks.TasksRepository
import com.example.appnotasmvvm.domain.tasks.model.Task
import com.example.appnotasmvvm.domain.tasks.model.toTaskEntity
import javax.inject.Inject

class UseCaseDeleteTask @Inject constructor(private val tasksRepository: TasksRepository){
    suspend operator fun invoke(task: Task){
        tasksRepository.deleteTask(task.toTaskEntity())
    }
}