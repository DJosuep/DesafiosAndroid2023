package com.example.lab1

import com.example.lab1.objeto.planeta

fun main(){
    do {
        println("Ingrese el nombre del planeta:")
        var nombre:String? = readLine().toString()

        println("\nIngrese el número de satelites que posee:")
        var satelites:Int? = readLine()?.toIntOrNull()

        println("\nIngrese la masa del planeta:")
        var masa:Double? = readLine()?.toDoubleOrNull()

        println("\nIngrese el volumen del planeta:")
        var volumen:Double? = readLine()?.toDoubleOrNull()

        println("\nIngrese la distancia del planeta al sol:")
        var distanciaSol:Int? = readLine()?.toIntOrNull()

        println("Ingrese el nombre del planeta:")
        var tipo:String? = readLine().toString()

        if (nombre != null && satelites != null && masa != null && volumen != null && distanciaSol != null && tipo != null){
            val planeta = planeta(nombre, satelites, masa, volumen, distanciaSol, tipo)

            planeta(nombre, satelites, masa, volumen, distanciaSol, tipo).nose()
        }
        else{
            println("Ingrese valores válidos.")
        }
    }while (satelites == null || masa == null || volumen == null || distanciaSol == null)
}