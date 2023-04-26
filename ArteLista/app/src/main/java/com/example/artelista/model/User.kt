package com.example.artelista.model

class User(private var nombreUsuario:String,
           private var categoriaUsuario:String,
           private var paisUsuario:String) {
    fun getNombreUsuario():String{return this.nombreUsuario}
    fun getCategoriaUsuario():String{return this.categoriaUsuario}
    fun getPaisUsuario():String{return this.paisUsuario}
}