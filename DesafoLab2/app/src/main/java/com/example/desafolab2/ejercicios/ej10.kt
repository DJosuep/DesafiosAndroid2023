package com.example.desafolab2.ejercicios

fun contador(){
    println("(10) Contar del 320 al 160 de 20 en 20:\n")

    for (ent in 320 downTo 160 step 20) {
        println("$ent\n")
    }
}