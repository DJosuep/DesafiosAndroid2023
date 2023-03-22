package com.example.desafolab2.ejercicios

fun multiplos(){
    var i:Int = 5

    println("(9) Múltiplos de 5 del 5 al 100:\n")

    do {
        if (i % 5 == 0) {
            println("$i\n")
        }
        i++
    } while (i <= 100)
}