package com.example.artelista

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.artelista.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //funcionalidad al boton Login
        binding.btnLogin.setOnClickListener {v->
            val intent = Intent(v.context, MainActivity::class.java)
            startActivity(intent)
        }

        //funcionalidad al textview crea aqui
        binding.tvCreaUnaAqui.setOnClickListener { v ->
            val intent = Intent(v.context, ActivityCrearCuenta::class.java)
            startActivity(intent)
        }
    }
}