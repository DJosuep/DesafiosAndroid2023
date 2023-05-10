package com.example.appnotas.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appnotas.model.Anotacion
import com.example.appnotas.utils.Constants

class DatabaseHelper(context : Context): SQLiteOpenHelper(
    context,
    Constants.DATABASE_NAME,
    null,Constants.DATABASE_VERSION
) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE ${Constants.ENTITY_TASK} (" +
                "${Constants.PROPERTY_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${Constants.PROPERTY_DESCRIPTION} VARCHAR(120)," +
                "${Constants.PROPERTY_FINALIZED} BOOLEAN)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    @SuppressLint("Range", "Recycle")
    fun getTasks():MutableList<Anotacion>{
        val tasks :MutableList<Anotacion> = mutableListOf()
        val database = this.readableDatabase
        val query = "SELECT * FROM ${Constants.ENTITY_TASK}"

        val result = database.rawQuery(query, null)

        if (result.moveToFirst()){
            do{
                val task = Anotacion(
                    id = result.getLong(result.getColumnIndex(Constants.PROPERTY_ID)),
                    task = result.getString(result.getColumnIndex(Constants.PROPERTY_DESCRIPTION)),
                    finish = result.getInt(result.getColumnIndex(Constants.PROPERTY_FINALIZED)) == Constants.TRUE
                )
                tasks.add(task)
            }while (result.moveToNext())
        }
        return tasks
    }

    fun insertTask(anota: Anotacion): Long {
        val database = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(Constants.PROPERTY_DESCRIPTION, anota.task)
            put(Constants.PROPERTY_FINALIZED, anota.finish)
        }

        return database.insert(Constants.ENTITY_TASK, null, contentValues)
    }

    fun updateTask(anota: Anotacion):Boolean{
        val database = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(Constants.PROPERTY_DESCRIPTION, anota.task)
            put(Constants.PROPERTY_FINALIZED, anota.finish)
        }

        return  database.update(Constants.ENTITY_TASK,
            contentValues,
            "${Constants.PROPERTY_ID} = ${anota.id}",
            null
        ) == Constants.TRUE
    }

    fun deleteTask(anota: Anotacion):Boolean{
        val database = this.writableDatabase

        return  database.delete(Constants.ENTITY_TASK,
            "${Constants.PROPERTY_ID} = ${anota.id}",
            null
        ) == Constants.TRUE
    }
}