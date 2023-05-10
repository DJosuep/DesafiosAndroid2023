package com.example.appnotasmvvm.data.tasks.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appnotasmvvm.data.tasks.TaskEntity
import com.example.appnotasmvvm.utils.Constants

@Dao
interface TaskDao {
    @Query("SELECT * FROM ${Constants.ENTITY_TASK}")
    fun getAll(): List<TaskEntity>

    @Insert
    fun insert(taskEntity: TaskEntity)

    @Update
    fun update(taskEntity: TaskEntity)

    @Delete
    fun delete(taskEntity: TaskEntity)
}