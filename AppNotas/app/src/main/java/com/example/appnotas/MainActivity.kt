package com.example.appnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnotas.adapter.AdapterAnotacion
import com.example.appnotas.databinding.ActivityMainBinding
import com.example.appnotas.model.Anotacion

class MainActivity : AppCompatActivity(), OnClickListener {
    //-----------------
    private lateinit var binding: ActivityMainBinding
    private lateinit var anotacionAdapter: AdapterAnotacion
    private lateinit var anotacionAdapterF: AdapterAnotacion

    //-----------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Pendientes
        anotacionAdapter = AdapterAnotacion(mutableListOf(), this)
        binding.rvAnotaciones.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = anotacionAdapter
        }

        //Finalizadas
        anotacionAdapterF = AdapterAnotacion(mutableListOf(), this)
        binding.rvAnotacionesFinalizadas.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = anotacionAdapterF
        }

        binding.btnAgregar.setOnClickListener {
            if (binding.tvDescripcionTarea.text.toString().isNotBlank()){
                val anota = Anotacion((anotacionAdapter.itemCount + 1).toLong(),
                                        binding.tvDescripcionTarea.text.toString())
                addAnotacion(anota)
                binding.tvDescripcionTarea.text?.clear()
            } else {
                binding.tvDescripcionTarea.error = getString(R.string.strValidacionError)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData() {
        val data = mutableListOf(
            Anotacion(1, "Tarea AWS"),
            Anotacion(2, "Registros secretos"),
            Anotacion(3, "Avenger Infinit"),
            Anotacion(4, "Contraseña del banco"),
            Anotacion(5, "xd ya no se que poner"),
            Anotacion(6, "Yo no lo descargo porque lo tengo", true)
        )
        data.forEach {
            addAnotacion(it)
        }
    }

    override fun onClick(anotacion: Anotacion, adapters: AdapterAnotacion) {
         val builder = AlertDialog.Builder(this)
             .setTitle(getString(R.string.strDialogTitulo))
             .setPositiveButton(getString(R.string.strAceptar)) { dialogInterface, i ->
                 adapters.remove(anotacion)
             }
             .setNegativeButton(getString(R.string.strCancelar), null)
        builder.create().show()
    }

    override fun onChecked(anotacion: Anotacion){
        deleteAnotacion(anotacion)
        addAnotacion(anotacion)
    }

    private fun deleteAnotacion(anota: Anotacion) {
        if (anota.finish){
            anotacionAdapter.remove(anota)
        }else{
            anotacionAdapterF.remove(anota)
        }
    }

    private fun addAnotacion(anota: Anotacion) {
        if (anota.finish){
            anotacionAdapterF.add(anota)
        }else{
            anotacionAdapter.add(anota)
        }
    }
}