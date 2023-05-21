package com.example.artelista.adapter

import com.example.artelista.model.Carrito

interface CarritoListener {
    fun onCarritoClicked(Carrito: Carrito, position: Int)
}