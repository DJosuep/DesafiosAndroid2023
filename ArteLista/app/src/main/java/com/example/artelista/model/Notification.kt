package com.example.artelista.model

class Notification(private var tituloNotification:String,
                   private var categoriaNotification:String,
                   private var horaNotification:String) {
    fun getTituloNotification():String{return this.tituloNotification}
    fun getCategoriaNotification():String{return this.categoriaNotification}
    fun getHoraNotification():String{return this.horaNotification}
}