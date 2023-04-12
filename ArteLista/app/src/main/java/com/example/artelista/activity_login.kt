package com.example.artelista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class activity_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Intent para crear instancia de la Main_activity
        val intent = Intent(this, MainActivity::class.java)

        //Crando una referencia al botton
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            startActivity(intent)
            finish()
        }
    }
}