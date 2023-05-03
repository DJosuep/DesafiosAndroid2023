package com.example.appnotas

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnotas.databinding.ItemNotasBinding
import com.example.appnotas.model.Anotacion

class AnotacionAdapter(var noteList: MutableList<Anotacion>,
                       private val listener: OnClickListener):
    RecyclerView.Adapter<AnotacionAdapter.ViewHolder>() {

    inner class ViewHolder(view: View){
        val binding = ItemNotasBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}