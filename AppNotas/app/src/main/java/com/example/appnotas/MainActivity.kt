package com.example.appnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnotas.adapter.AdapterAnotacion
import com.example.appnotas.database.DatabaseHelper
import com.example.appnotas.databinding.ActivityMainBinding
import com.example.appnotas.model.Anotacion
import com.example.appnotas.utils.Constants
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    //-----------------
    private lateinit var binding: ActivityMainBinding
    private lateinit var anotacionAdapter: AdapterAnotacion
    private lateinit var anotacionAdapterF: AdapterAnotacion
    private lateinit var database: DatabaseHelper

    //-----------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        database = DatabaseHelper(this)
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

        //AgregarAnotaciones desde la base de datos
        getData()

        binding.btnAgregar.setOnClickListener {
            if (binding.tvDescripcionTarea.text.toString().isNotBlank()){
                val anota = Anotacion((anotacionAdapter.itemCount + 1).toLong(),
                                        binding.tvDescripcionTarea.text.toString())
                anota.id = database.insertTask(anota)

                if (anota.id != Constants.ID_ERROR){
                    addAnotacion(anota)
                    binding.tvDescripcionTarea.text?.clear()
                    Snackbar.make(binding.root, "Se agreg tarea", Snackbar.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                Snackbar.make(binding.root, "Error al agregar tarea", Snackbar.LENGTH_SHORT).show()
            } else {
                binding.tvDescripcionTarea.error = getString(R.string.strValidacionError)
            }
        }
    }

    private fun getData() {
        val data = database.getTasks()
        data.forEach {
            addAnotacion(it)
        }
    }

    override fun onClick(anotacion: Anotacion, adapters: AdapterAnotacion) {
         val builder = AlertDialog.Builder(this)
             .setTitle(getString(R.string.strDialogTitulo))
             .setPositiveButton(getString(R.string.strAceptar)) { dialogInterface, i ->
                 if (database.deleteTask(anotacion)){
                     adapters.remove(anotacion)
                     Snackbar.make(binding.root, "Se a eliminado la tarea correctamente", Snackbar.LENGTH_SHORT).show()
                     return@setPositiveButton
                 }
                 Snackbar.make(binding.root, "Error al eliminar tarea", Snackbar.LENGTH_SHORT).show()
             }
             .setNegativeButton(getString(R.string.strCancelar), null)
        builder.create().show()
    }

    override fun onChecked(anotacion: Anotacion){
        if (database.updateTask(anotacion)){
            deleteAnotacion(anotacion)
            addAnotacion(anotacion)
            return
        }
        Snackbar.make(binding.root, "Error al actualizar tarea", Snackbar.LENGTH_SHORT).show()
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