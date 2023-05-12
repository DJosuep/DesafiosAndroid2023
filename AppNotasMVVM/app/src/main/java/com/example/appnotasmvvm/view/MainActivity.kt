package com.example.appnotasmvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnotasmvvm.R
import com.example.appnotasmvvm.databinding.ActivityMainBinding
import com.example.appnotasmvvm.domain.tasks.model.Task
import com.example.appnotasmvvm.view.adapter.AdapterTask
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), com.example.appnotasmvvm.utils.OnClickListener {
    private lateinit var binding : ActivityMainBinding
    private lateinit var anotacionAdapter: AdapterTask
    private lateinit var anotacionAdapterF: AdapterTask
    private val mainViewModel : MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Pendientes
        anotacionAdapter = AdapterTask(this)
        binding.rvAnotaciones.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = anotacionAdapter
        }

        //Finalizadas
        anotacionAdapterF =AdapterTask(this)
        binding.rvAnotacionesFinalizadas.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = anotacionAdapterF
        }

        binding.btnAgregar.setOnClickListener {
           if (binding.tvDescripcionTarea.text.toString().isNotBlank()){
               val task = Task(
                   description = binding.tvDescripcionTarea.text.toString()
               )
               binding.tvDescripcionTarea.text?.clear()
               Snackbar.make(binding.root, R.string.strAddTask, Snackbar.LENGTH_SHORT).show()
               mainViewModel.addTask(task)
           } else {
               binding.tvDescripcionTarea.error = getString(R.string.strValidacionError)
           }
        }

        //LLenando las listas de los adapters
        mainViewModel.tasksLiveData.observe(this){
            addTask(it.toMutableList())
        }
    }

    private fun addTask(task: MutableList<Task>) {
        val cacheTask: MutableList<Task> = mutableListOf()
        val cacheTaskFinalized : MutableList<Task> = mutableListOf()

        task.forEach{
            if (it.finalized){
                cacheTaskFinalized.add(it)
            }else{
                cacheTask.add(it)
            }
        }

        anotacionAdapter.updateTasks(cacheTask)
        anotacionAdapterF.updateTasks(cacheTaskFinalized)
    }
    override fun onChecked(task: Task) {
        mainViewModel.updateTask(task)
    }

    override fun onClick(task: Task, adapters: AdapterTask) {
        val builder = AlertDialog.Builder(this)
            .setTitle(getString(R.string.strDialogTitulo))
            .setPositiveButton(getString(R.string.strAceptar)) { _, _ ->
                mainViewModel.deleteTask(task)
                Snackbar.make(binding.root, R.string.strDeleteTask, Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
            }
            .setNegativeButton(getString(R.string.strCancelar), null)
        builder.create().show()
    }
}