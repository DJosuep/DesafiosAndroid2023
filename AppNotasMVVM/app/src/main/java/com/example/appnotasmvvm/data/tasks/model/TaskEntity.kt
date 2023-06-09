package com.example.appnotasmvvm.data.tasks.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.appnotasmvvm.utils.Constants

@Entity(tableName = Constants.ENTITY_TASK)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.PROPERTY_ID ) val uid : Int = 0,
    @ColumnInfo(name = Constants.PROPERTY_DESCRIPTION) val description : String,
    @ColumnInfo(name = Constants.PROPERTY_FINALIZED) val finalized : Boolean
    )
