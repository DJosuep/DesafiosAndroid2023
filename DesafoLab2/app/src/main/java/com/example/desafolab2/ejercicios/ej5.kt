package com.example.desafolab2.ejercicios

fun saludoPorHora(){
    println("(5) Saludos según la hora del día:\n")

    do {
        println("Ingrese una hora:")
        val hora = readLine()?.toIntOrNull()

        if (hora != null && hora > 0 && hora < 25){
            when(hora){
                in 6..12 -> println("\nBuenos días.\n")
                in 13..20 -> println("\nBuenas tardes.\n")
                else -> println("\nBuenas noches.\n")
            }
        }
        else{
            print("\nEl dato no es correcto, intente de nuevo.\n")
        }
    } while (hora == null)
}