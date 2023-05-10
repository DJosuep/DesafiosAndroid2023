package com.example.appnotasmvvm.view

import androidx.lifecycle.ViewModel
import com.example.appnotasmvvm.domain.tasks.UseCaseAddTask
import com.example.appnotasmvvm.domain.tasks.UseCaseDeleteTask
import com.example.appnotasmvvm.domain.tasks.UseCaseGetTasks
import com.example.appnotasmvvm.domain.tasks.UseCaseUpdateTask
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val useCaseAddTask: UseCaseAddTask,
    private val useCaseDeleteTask: UseCaseDeleteTask,
    private val useCaseGetTasks: UseCaseGetTasks,
    private val useCaseUpdateTask: UseCaseUpdateTask
) : ViewModel() {
    
}