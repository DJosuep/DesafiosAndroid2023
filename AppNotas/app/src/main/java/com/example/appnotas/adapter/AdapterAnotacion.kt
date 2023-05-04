package com.example.appnotas.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotas.OnClickListener
import com.example.appnotas.R
import com.example.appnotas.databinding.ItemNotasBinding
import com.example.appnotas.model.Anotacion

class AdapterAnotacion(
    private var anotacionList: MutableList<Anotacion>,
    private val listener: OnClickListener):
    RecyclerView.Adapter<AdapterAnotacion.ViewHolder>(){

    private lateinit var context: Context
        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val binding = ItemNotasBinding.bind(view)

            //Eliminar item de la lista
            @Suppress("UNUSED_EXPRESSION")
            fun setListener(anota: Anotacion){
                binding.checkFinalizado.setOnClickListener{
                    anota.finish = (it as CheckBox).isChecked
                    listener.onChecked(anota)
                }
                binding.root.setOnClickListener {
                    listener.onClick(anota, this@AdapterAnotacion)
                    true
                }
            }
            //----------------------------
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_notas, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int = anotacionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anotacion = anotacionList[position]
        holder.setListener(anotacion)
        holder.binding.tvTarea.text = anotacion.task
        holder.binding.checkFinalizado.isChecked = anotacion.finish

        if(anotacion.finish){
            holder.binding.tvTarea.setTextSize(TypedValue.COMPLEX_UNIT_SP,context.resources.getDimension(R.dimen.tamtexto1))
        }
        else{
            holder.binding.tvTarea.setTextSize(TypedValue.COMPLEX_UNIT_SP, context.resources.getDimension(R.dimen.tamtexto2))
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun add(anota: Anotacion){
        anotacionList.add(anota)
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun remove(anota: Anotacion){
        anotacionList.remove(anota)
        notifyDataSetChanged()
    }
}