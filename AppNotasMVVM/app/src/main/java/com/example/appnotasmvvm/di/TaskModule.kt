package com.example.appnotasmvvm.di

import android.content.Context
import androidx.room.Room
import com.example.appnotasmvvm.data.tasks.TaskDao
import com.example.appnotasmvvm.data.tasks.TaskDatabase
import com.example.appnotasmvvm.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object TaskModule {

    @Singleton
    @Provides
    fun providesTaskDatabase(@ApplicationContext app:Context) : TaskDatabase{
        return Room.databaseBuilder(
            app,
            TaskDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun providesTaskDao(db : TaskDatabase) : TaskDao = db.taskDao()
}