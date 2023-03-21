package com.example.desafolab2

import kotlin.math.pow

fun main() {
    /*triangulo()
    circulo()
    salarioSemanal()
    palabrasSpanglish()
    saludoPorHora()
    diaSemana()
    ordenar(5, 3, 7)*/
}

fun triangulo(){
    print("(1) Área del triángulo:")

    do {
        print("\nIngrese la altura del triángulo:\n")
        var altura = readLine()?.toIntOrNull()
        print("\nIngrese la base del triángulo:\n")
        var base = readLine()?.toIntOrNull()

        /* Validaciones */
        if (base != null && altura != null){
            val areaTriangulo = (base.toFloat() * altura.toFloat()) / 2
            print("\nEl área de su triángulo es $areaTriangulo unidades.\n\n")
        }
        else{
            print("\nUno de los datos no es correcto, intente de nuevo.\n")
        }
    }while (base == null || altura == null)
}

fun circulo(){
    val pi = 3.1416

    print("(2) Área del círculo:")

    do {
        print("\nIngrese el radio del círculo:\n")
        var radio = readLine()?.toFloatOrNull()

        /* Validaciones */
        if (radio != null){
            val areaCirculo = pi * radio.pow(2)
            print("\nEl área de su círculo es $areaCirculo unidades.\n\n")
        }
        else{
            print("\nEl dato no es correcto, intente de nuevo.\n")
        }
    }while (radio == null)
}

fun salarioSemanal(){
    val paga = 12

    print("(3) Calcular el salario semanal con base en las horas trabajadas:")
    do {
        print("\nIngrese las horas trabajadas en la semana:\n")
        var horas = readLine()?.toIntOrNull()
        print("\nIngrese los días trabajados en la semana:\n")
        var dias = readLine()?.toIntOrNull()

        /* Validaciones */
        if (dias != null && horas != null && dias > 0 && dias < 8 && horas > 0 && horas < 25){
            val salario = (paga * horas) * dias
            print("\nEl salario semanal es de $$salario.")
        }
        else{
            print("\nVerifique que los valores ingresados sean correctos o que no sean muy grandes.\n")
        }
    }while (horas == null || dias == null)
}

fun palabrasSpanglish(){
    val palabrasEn = arrayOf("Butterfly", "Window", "Program", "Desk", "Five", "Array", "Chain", "Folder", "Glass", "Ten", "Sky", "Reverse", "Word", "Mouse", "Fifteen", "Keyboard", "Space", "Key", "Light", "Eye")
    val palabrasEs = arrayOf("Mariposa", "Ventana", "Programa", "Escritorio", "Cinco", "Arreglo", "Cadena", "Carpeta", "Vidrio", "Diez", "Cielo", "Reversa", "Palabra", "Mouse", "Quince", "Teclado", "Espacio", "Llave", "Luz", "Ojo")

    println("Español\t\t\tEnglish\n")

    for(i in 0..19){
        println("${palabrasEs[i]}\t\t\t${palabrasEn[i]}\n")
    }
}

fun saludoPorHora(){
    do {
        println("Ingrese una hora:")
        val hora = readLine()?.toIntOrNull()

        if (hora != null){
            if (hora in 6..12){
                println("\nBuenos días.\n")
            }
            else if (hora in 13..20){
                println("\nBuenas tardes.\n")
            }
            else{
                println("\nBuenas noches.\n")
            }
        }
        else{
            print("\nEl dato no es correcto, intente de nuevo.\n")
        }
    } while (hora == null)
}

fun diaSemana(){
    do {
        println("Ingrese un número del 1 al 7:")

        var num = readLine()?.toIntOrNull()

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
    } while (num == null)
}

fun ordenar(a: Int, b: Int, c: Int){
    val arreglo = arrayOf(a, b, c)

    /* Ordena el array de forma ascendente */
    arreglo.sort()

    /* Convierte el array en una cadena separada por comas y los muestra */
    println("Los números ordenados son: ${arreglo.joinToString()}.\n")
}

