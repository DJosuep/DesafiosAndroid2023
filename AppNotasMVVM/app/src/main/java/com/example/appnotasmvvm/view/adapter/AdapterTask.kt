package com.example.appnotasmvvm.view.adapter
import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotasmvvm.utils.OnClickListener
import com.example.appnotasmvvm.R
import com.example.appnotasmvvm.databinding.ItemTaskBinding
import com.example.appnotasmvvm.domain.tasks.model.Task

class AdapterTask(
    private var taskList: MutableList<Task>,
    private val listener: OnClickListener
):
    RecyclerView.Adapter<AdapterTask.ViewHolder>(){

    private lateinit var context: Context
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemTaskBinding.bind(view)

        //Eliminar item de la lista
        @Suppress("UNUSED_EXPRESSION")
        fun setListener(task: Task){
            binding.checkFinalizado.setOnClickListener{
                task.finalized = (it as CheckBox).isChecked
                listener.onChecked(task)
            }
            binding.root.setOnClickListener {
                listener.onClick(task, this@AdapterTask)
                true
            }
        }
        //----------------------------
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int = taskList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tasks = taskList[position]
        holder.setListener(tasks)
        holder.binding.tvTarea.text = tasks.description
        holder.binding.checkFinalizado.isChecked = tasks.finalized

        if(tasks.finalized){
            holder.binding.tvTarea.setTextSize(TypedValue.COMPLEX_UNIT_SP,context.resources.getDimension(R.dimen.tamtexto1))
        }
        else{
            holder.binding.tvTarea.setTextSize(TypedValue.COMPLEX_UNIT_SP, context.resources.getDimension(R.dimen.tamtexto2))
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun add(task: Task){
        taskList.add(task)
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun remove(task: Task){
        taskList.remove(task)
        notifyDataSetChanged()
    }
}