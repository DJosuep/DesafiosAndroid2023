package com.example.artelista

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artelista.databinding.ActivityCrearcuentaBinding
import com.example.artelista.databinding.ActivityLoginBinding

class ActivityCrearCuenta : AppCompatActivity() {
   private  lateinit var binding: ActivityCrearcuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearcuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tbCrearCuenta)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}