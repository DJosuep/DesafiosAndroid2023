package com.example.appnotas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotas.OnClickListener
import com.example.appnotas.R
import com.example.appnotas.databinding.ItemNotasBinding
import com.example.appnotas.model.Anotacion

class AdapterAnotacion(var anotacionList: MutableList<Anotacion>,
                        private val listener: OnClickListener):
    RecyclerView.Adapter<AdapterAnotacion.ViewHolder>(){

        inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val binding = ItemNotasBinding.bind(view)

            //Eliminar item de la lista
            fun setListener(anota: Anotacion){
                binding.root.setOnClickListener {
                    listener.onClick(anota)
                    true
                }
            }
            //----------------------------
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notas, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount(): Int = anotacionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anotacion = anotacionList[position]
        holder.binding.tvTarea.text = anotacion.task
    }
    fun add(anota: Anotacion){
        anotacionList.add(anota)
        notifyDataSetChanged()
    }
    fun remove(anota: Anotacion){
        anotacionList.remove(anota)
        notifyDataSetChanged()
    }
}