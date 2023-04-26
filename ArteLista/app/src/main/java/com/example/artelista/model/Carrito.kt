package com.example.artelista.model

class Carrito(
    private var artistaCarrito:String,
    private var precioCarrito:String,
    private var imagenCarrito:String,
    private var tituloCarrito:String
    ) {
    fun getVendedorCarrito():String{ return this.artistaCarrito }
    fun getPrecioCarrito():String{ return this.precioCarrito }
    fun getImagenCarrito():String{ return this.imagenCarrito }
    fun getTituloCarrito():String{ return this.tituloCarrito }
}