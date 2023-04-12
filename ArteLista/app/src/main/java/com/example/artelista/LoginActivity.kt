package com.example.artelista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Intent para crear instancia de la Main_activity
        val intent = Intent(this, MainActivity::class.java)

        //Crando una referencia a los elementos
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvCreate = findViewById<TextView>(R.id.tvCreaUnaAqui)

        //funcionalidad al boton Login
        btnLogin.setOnClickListener {
            startActivity(intent)
            finish()
        }

        //funcionalidad al textview crea aqui
        tvCreate.setOnClickListener{
            
        }

    }
}