package com.example.appnotasmvvm

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appnotasmvvm.data.tasks.local.TaskDao
import com.example.appnotasmvvm.data.tasks.local.TaskDatabase
import com.example.appnotasmvvm.data.tasks.TaskEntity
import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TaskDatabaseInstrumentedTest {

    private lateinit var taskDao: TaskDao
    private lateinit var db: TaskDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TaskDatabase::class.java).build()
        taskDao = db.taskDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeTaskAndReadAllTasks() {
        val hola = "Hola"
        //CrearInstancia
        val task = TaskEntity(1, description = hola, finalized = false)

        //Insertamos Instancia
        taskDao.insert(task)

        //Leer Instancia
        val tasks = taskDao.getAll()

        //Borrar Instancia
        taskDao.delete(taskEntity =  task)

        //Mostrar Lista Por consola
        println(tasks)

        //Probar si el resultado es el esperado
        assertEquals(tasks[0].description, hola)
    }

}