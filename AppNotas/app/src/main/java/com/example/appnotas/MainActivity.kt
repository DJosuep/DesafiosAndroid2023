package com.example.appnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appnotas.model.Anotacion

class MainActivity : AppCompatActivity(), OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(anotacion: Anotacion) {
        TODO("Not yet implemented")
    }
}