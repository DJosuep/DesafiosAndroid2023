package com.example.appnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appnotas.adapter.AdapterAnotacion
import com.example.appnotas.databinding.ActivityMainBinding
import com.example.appnotas.model.Anotacion

class MainActivity : AppCompatActivity(), OnClickListener {
    //-----------------
    private lateinit var binding: ActivityMainBinding
    private lateinit var anotacionAdapter: AdapterAnotacion
    //-----------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(anotacion: Anotacion) {
        TODO("Not yet implemented")
    }
}