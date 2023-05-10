package com.example.appnotasmvvm.data.tasks

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appnotasmvvm.utils.Constants

@Database(entities = [TaskEntity::class], version = Constants.DATABASE_VERSION)
abstract class TaskDatabase : RoomDatabase() {
    abstract  fun taskDao() : TaskDao
}