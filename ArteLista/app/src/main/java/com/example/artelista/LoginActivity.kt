package com.example.artelista

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Crando una referencia a los elementos
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvCrearCuenta:TextView = findViewById(R.id.tvCreaUnaAqui)

        //funcionalidad al boton Login
        btnLogin.setOnClickListener {v->
            val intent = Intent(v.context, MainActivity::class.java)
            startActivity(intent)
        }

        //funcionalidad al textview crea aqui
        tvCrearCuenta.setOnClickListener { v ->
            val intent = Intent(v.context, ActivityCrearCuenta::class.java)
            startActivity(intent)
        }
    }
}