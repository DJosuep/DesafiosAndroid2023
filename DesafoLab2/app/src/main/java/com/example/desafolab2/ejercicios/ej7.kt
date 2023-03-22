package com.example.desafolab2.ejercicios

fun ordenar(a: Int, b: Int, c: Int){
    val arreglo = arrayOf(a, b, c)

    println("(7) Números ordenados y desordenados:\n")

    /* Convierte el array en una cadena separada por comas y los muestra */
    println("Los números desordenados son: ${arreglo.joinToString()}.\n")

    /* Ordena el array de forma ascendente */
    arreglo.sort()

    println("Los números ordenados son: ${arreglo.joinToString()}.\n")
}

