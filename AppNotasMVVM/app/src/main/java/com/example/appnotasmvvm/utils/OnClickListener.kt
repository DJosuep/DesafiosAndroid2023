package com.example.appnotasmvvm.utils
import com.example.appnotasmvvm.domain.tasks.model.Task
import com.example.appnotasmvvm.view.adapter.AdapterTask

interface OnClickListener {
    fun onChecked(task: Task)
    fun onClick(task: Task, adapters: AdapterTask)
}