package com.example.appnotasmvvm.domain.tasks

import com.example.appnotasmvvm.data.tasks.TasksRepository
import com.example.appnotasmvvm.domain.tasks.model.Task
import com.example.appnotasmvvm.domain.tasks.model.toTask
import javax.inject.Inject

class UseCaseGetTasks @Inject constructor(
    private  val tasksRepository: TasksRepository
){
    suspend operator fun invoke(): List<Task>{
        return tasksRepository.getAllTasks().map { it.toTask() }
    }
}