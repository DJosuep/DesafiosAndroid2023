package com.example.appnotasmvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnotasmvvm.R
import com.example.appnotasmvvm.databinding.ActivityMainBinding
import com.example.appnotasmvvm.domain.tasks.model.Task
import com.example.appnotasmvvm.view.adapter.AdapterTask
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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

        lifecycle.coroutineScope.launch {
            mainViewModel.getTasksCompleted(false).collect {
                anotacionAdapter.submitList(it)
            }
        }

        lifecycle.coroutineScope.launch {
            mainViewModel.getTasksCompleted(true).collect {
                anotacionAdapterF.submitList(it)
            }
        }

        binding.btnAgregar.setOnClickListener {
           if (binding.tvDescripcionTarea.text.toString().isNotBlank()){
               val task = Task(
                   description = binding.tvDescripcionTarea.text.toString()
               )
               binding.tvDescripcionTarea.text?.clear()
               mainViewModel.addTask(task)
               Snackbar.make(binding.root, R.string.strAddTask, Snackbar.LENGTH_SHORT).show()
           } else {
               binding.tvDescripcionTarea.error = getString(R.string.strValidacionError)
           }
        }
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