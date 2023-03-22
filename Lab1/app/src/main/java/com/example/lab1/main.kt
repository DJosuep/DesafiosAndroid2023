package com.example.lab1

import com.example.lab1.ejercicio1.planeta
import com.example.lab1.ejercicio1.tipoPlaneta
import com.example.lab1.ejercicio2.ej2
import com.example.lab1.ejercicio3.ej3

fun main(){
    println("Integrantes del grupo:   \nDavid Antonio Torres Carcache.   \nPável Josué García Rivas.\n")

    /* Ejercicio 1 */
    var planeta = planeta("A-123", 2, 585530.0, 2045480.0, 1870000, tipoPlaneta.terrestre)

    println("La densidad del planeta es de ${planeta.obtenerDensidad().toString()} kg/m^3.")
    println("El planeta es ${planeta.esExterior()}.")

    /* Ejercicio 2 */
    ej2()

    /* Ejercicio 3 */
    ej3()
}