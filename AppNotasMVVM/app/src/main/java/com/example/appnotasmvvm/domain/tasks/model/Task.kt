package com.example.appnotasmvvm.domain.tasks.model

import com.example.appnotasmvvm.data.tasks.model.TaskEntity

data class Task(
    val id: Int,
    val description: String,
    val finalized: Boolean
)

fun TaskEntity.toTask(): Task = Task(id = uid, description = description, finalized = finalized)
fun Task.toTaskEntity(): TaskEntity = TaskEntity(uid = id, description = description, finalized = finalized)
