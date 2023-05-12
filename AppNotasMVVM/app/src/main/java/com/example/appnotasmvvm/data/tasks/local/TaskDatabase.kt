package com.example.appnotasmvvm.data.tasks.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appnotasmvvm.data.tasks.model.TaskEntity
import com.example.appnotasmvvm.utils.Constants

@Database(entities = [TaskEntity::class], version = Constants.DATABASE_VERSION)
abstract class TaskDatabase : RoomDatabase() {
    abstract  fun taskDao() : TaskDao
}