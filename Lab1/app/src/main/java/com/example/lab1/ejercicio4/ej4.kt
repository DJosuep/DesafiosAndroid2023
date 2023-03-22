package com.example.lab1.ejercicio4

class Libreria(var nombre:String, var direccion:String, var telefono:Byte = 0, var colaboradores:Byte = 0, var abierto:Boolean = true) {
    fun bienvendida(){
        println("Bienvenido/a.")
    }

    override fun toString():String{
        return ("La librería $nombre se ubica en $direccion.")
    }
}

fun ej4(){
    val lib = Libreria("Santiago", "Jinotepe")

    println("\n------------------ Ejercicio (4) ------------------\n")

    lib.bienvendida()

    if (lib.abierto == false){
        println("La librería está cerrada.")
    }

    println("\nMétodo override:")

    println(lib.toString())
}