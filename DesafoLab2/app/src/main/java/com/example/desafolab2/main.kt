package com.example.desafolab2

import com.example.desafolab2.ejercicios.*

fun main() {
    do {
        println("Ingrese un número del 1 al 10 para seleccionar los ejercicios.\nIngrese 11 para salir.")

        var opcion:Int? = readLine()?.toIntOrNull()

        if (opcion != null){
            menu(opcion)
        }
    }while (opcion != 11)
}

fun menu(opcion:Int){
    when(opcion){
        1 -> triangulo()
        2 -> circulo()
        3 -> salarioSemanalColab()
        4 -> palabrasSpanglish()
        5 -> saludoPorHora()
        6 -> diaSemana()
        7 -> ordenar(5, 4, 6)
        8 -> salarioSemanalTrab()
        9 -> multiplos()
        10 -> contador()
        11 -> return
        else -> println("\nOpción inválida. Seleccione solo números del 1 al 11.\n")
    }
}


