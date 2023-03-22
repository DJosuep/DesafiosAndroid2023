package com.example.lab1

import com.example.lab1.ejercicio1.Planeta
import com.example.lab1.ejercicio1.TipoPlaneta
import com.example.lab1.ejercicio2.ej2
import com.example.lab1.ejercicio3.ej3
import com.example.lab1.ejercicio4.ej4

fun main(){
    println("Integrantes del grupo:   \nDavid Antonio Torres Carcache.   \nPável Josué García Rivas.\n")

    /* Ejercicio 1 */
    var planeta = Planeta("A-123", 2, 585530.0, 2045480.0, 1870000, TipoPlaneta.terrestre)

    println("La densidad del planeta es de ${planeta.obtenerDensidad().toString()} kg/m^3.")
    println("El planeta es ${planeta.esExterior()}.")

    /* Ejercicio 2 */
    ej2()

    /* Ejercicio 3 */
    ej3()

    /* Ejercicio 4 */
    ej4()
}