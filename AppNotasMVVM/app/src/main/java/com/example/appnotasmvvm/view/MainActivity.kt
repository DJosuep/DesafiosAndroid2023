package com.example.appnotasmvvm.view

import android.os.Bundle
import androidx.activity.viewModels
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

        //Lenando la lista
        mainViewModel.getAllTaskList()

        //LLenando las listas de los adapters
        mainViewModel.tasksLiveData.observe(this){
               it.forEach{ task ->
                   addTask(task)
               }
        }


        binding.btnAgregar.setOnClickListener {
           if (binding.tvDescripcionTarea.text.toString().isNotBlank()){
               val task = Task(
                   (anotacionAdapter.itemCount + 1),
                   binding.tvDescripcionTarea.text.toString()
               )
               mainViewModel.addTask(task)
               binding.tvDescripcionTarea.text?.clear()
               Snackbar.make(binding.root, R.string.strAddTask, Snackbar.LENGTH_SHORT).show()
           } else {
               binding.tvDescripcionTarea.error = getString(R.string.strValidacionError)
           }
        }
    }

    private fun addTask(task: Task) {
        if (task.finalized){
            anotacionAdapterF.add(task)
        }else{
            anotacionAdapter.add(task)
        }
    }
    override fun onChecked(task: Task) {
        TODO("implementar suceso de cambiar de recycleview al darle check a la task")
    }

    override fun onClick(task: Task, adapters: AdapterTask) {
        TODO("implementar suceso de eliminar al darle click a la task")

    }
}