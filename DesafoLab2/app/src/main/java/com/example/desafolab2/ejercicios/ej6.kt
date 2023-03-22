package com.example.desafolab2.ejercicios

fun diaSemana(){
    println("(6) Número del día de la semana:\n")

    do {
        println("Ingrese un número del 1 al 7:")

        var num = readLine()?.toIntOrNull()

        if (num != null){
            when (num) {
                1 -> println("\nLunes.\n")
                2 -> println("\nMartes.\n")
                3 -> println("\nMiércoles.\n")
                4 -> println("\nJueves.\n")
                5 -> println("\nViernes.\n")
                6 -> println("\nSábado.\n")
                7 -> println("\nDomingo.\n")
                else -> println("\nEl dato no es correcto, intente de nuevo.\n")
            }
        }
        else{
            println("\nEl dato no es correcto, intente de nuevo.\n")
        }
    } while (num == null)
}