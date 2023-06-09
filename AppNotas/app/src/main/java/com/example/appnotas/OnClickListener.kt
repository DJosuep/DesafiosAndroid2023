package com.example.appnotas
import com.example.appnotas.adapter.AdapterAnotacion
import com.example.appnotas.model.Anotacion

interface OnClickListener {
    fun onChecked(anotacion: Anotacion)
    fun onClick(anotacion: Anotacion, adapters: AdapterAnotacion)
}