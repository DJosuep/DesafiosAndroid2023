package com.example.appnotasmvvm.domain.tasks

import com.example.appnotasmvvm.data.tasks.TasksRepository
import com.example.appnotasmvvm.domain.tasks.model.Task
import com.example.appnotasmvvm.domain.tasks.model.toTask
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.w3c.dom.Entity
import javax.inject.Inject

class UseCaseGetTasksCompled @Inject constructor(
    private  val tasksRepository: TasksRepository
){
    operator fun invoke(finalized : Boolean): Flow<List<Task>>{
        return tasksRepository.getAllTaskCompled(finalized).map {TasksEntity ->
            TasksEntity.map { it.toTask() }
        }
    }
}