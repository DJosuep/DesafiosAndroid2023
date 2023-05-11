package com.example.appnotasmvvm.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appnotasmvvm.domain.tasks.UseCaseAddTask
import com.example.appnotasmvvm.domain.tasks.UseCaseDeleteTask
import com.example.appnotasmvvm.domain.tasks.UseCaseGetTasks
import com.example.appnotasmvvm.domain.tasks.UseCaseUpdateTask
import com.example.appnotasmvvm.domain.tasks.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val useCaseAddTask: UseCaseAddTask,
    private val useCaseDeleteTask: UseCaseDeleteTask,
    private val useCaseGetTasks: UseCaseGetTasks,
    private val useCaseUpdateTask: UseCaseUpdateTask
) : ViewModel() {
    private var _tasksLiveData: MutableLiveData<List<Task>> = MutableLiveData()
    val tasksLiveData : LiveData<List<Task>> get() = _tasksLiveData

    fun getAllTaskList() {
        viewModelScope.launch(Dispatchers.IO) {
            val fetchTasks = useCaseGetTasks()
            withContext(Dispatchers.Main){
                _tasksLiveData.postValue(fetchTasks)
            }
        }
    }
    fun deleteTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            useCaseDeleteTask(task)
        }
    }

    fun updateTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            useCaseUpdateTask(task)
        }
    }

    fun addTask(task: Task){
        viewModelScope.launch {
            useCaseAddTask(task)
        }
    }
}