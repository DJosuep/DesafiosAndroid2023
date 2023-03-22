package com.example.lab1.ejercicio5

open class Persona(val nombre:String, val apellido:String) {
    var tipoPersona:String = ""

    fun getNombreCompleto():String = "$nombre $apellido"
    open fun showTipoPersona():String {
        return "Desconocido."
    }
}

class Colaborador(nombre:String, apellido:String, var cantHijos:Short) : Persona(nombre, apellido){
    override fun showTipoPersona(): String {
        return super.getNombreCompleto() + ":\nCantidad de hijos: ${cantHijos}."
    }
}

class Cliente(nombre: String, apellido: String, telefono:Int) : Persona(nombre, apellido){
    private var telefono:Int = 0

    init {
        this.telefono = telefono
    }

    fun getCliente():String{
        return "Datos del cliente:\nTeléfono: $telefono.\nNombre: $nombre."
    }

    override fun showTipoPersona(): String {
        return "Cliente."
    }
}

fun ej5(){
    val cliente = Cliente("Pedro", "Rodríguez", 225762044)
    val colaborador = Colaborador("Rosa", "Jirón", 5)

    println("\n------------------ Ejercicio (5) ------------------\n")


    println("---Clase Cliente:")
    println(cliente.showTipoPersona())
    println(cliente.getNombreCompleto()+".")
    println(cliente.getCliente())

    println("\n---Clase Colaborador:")
    println(colaborador.showTipoPersona())
    println(cliente.getNombreCompleto()+".")
}