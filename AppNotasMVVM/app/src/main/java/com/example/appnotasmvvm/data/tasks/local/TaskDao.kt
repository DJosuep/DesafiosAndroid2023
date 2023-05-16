package com.example.appnotasmvvm.data.tasks.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.appnotasmvvm.data.tasks.model.TaskEntity
import com.example.appnotasmvvm.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM ${Constants.ENTITY_TASK}")
    suspend fun getAll(): List<TaskEntity>

    @Query("SELECT * FROM ${Constants.ENTITY_TASK} WHERE ${Constants.PROPERTY_FINALIZED} = :finalized")
    fun getAllCompleted(finalized : Boolean): Flow<List<TaskEntity>>

    @Insert
    suspend fun insert(taskEntity: TaskEntity)

    @Update
    suspend fun update(taskEntity: TaskEntity)

    @Delete
    suspend fun delete(taskEntity: TaskEntity)
}