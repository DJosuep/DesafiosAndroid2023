package com.example.artelista

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artelista.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //funcionalidad al boton Login
        binding.btnLogin.setOnClickListener {v->
            val intent = Intent(v.context, MenuActivity::class.java)
            startActivity(intent)
        }

        //funcionalidad al textview crea aqui
        binding.tvCreaUnaAqui.setOnClickListener { v ->
            val intent = Intent(v.context, ActivityCrearCuenta::class.java)
            startActivity(intent)
        }
    }
}