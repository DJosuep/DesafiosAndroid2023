package com.example.lab1

import com.example.lab1.objeto.planeta
import com.example.lab1.objeto.tipoPlaneta

fun main(){
    var planeta = planeta("A-123", 2, 500.0, 200.0, 500000000, tipoPlaneta.terrestre)

    println("La densidad del planeta es de ${planeta.obtenerDensidad().toString()} kg/m^3.")
    if
}