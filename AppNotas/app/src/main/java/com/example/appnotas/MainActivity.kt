package com.example.appnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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

        val data = mutableListOf(
            Anotacion(1, "Tarea AWS"),
            Anotacion(2, "Registros secretos"),
            Anotacion(3, "Avenger Infinit"),
            Anotacion(4, "Contraseña del banco"),
            Anotacion(5, "xd ya no se que poner"),
            Anotacion(6, "Yo no lo descargo porque lo tengo")
        )

        anotacionAdapter = AdapterAnotacion(data, this)
        binding.rvAnotaciones.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = anotacionAdapter
        }

        binding.btnAgregar.setOnClickListener {
            if (binding.tvDescripcionTarea.text.toString().isNotBlank()){
                val anota = Anotacion((anotacionAdapter.itemCount + 1).toLong(),
                                        binding.tvDescripcionTarea.text.toString())
                addAnotacion(anota)
                binding.tvDescripcionTarea.text?.clear()
            }
        }
    }

    override fun onClick(anota: Anotacion) {
        deleteAnotacion(anota)
    }

    private fun deleteAnotacion(anota: Anotacion) {
        anotacionAdapter.remove(anota)
    }

    private fun addAnotacion(anota: Anotacion) {
        anotacionAdapter.add(anota)
    }
}