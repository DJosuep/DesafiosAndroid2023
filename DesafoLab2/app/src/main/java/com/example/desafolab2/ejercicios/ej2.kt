package com.example.desafolab2.ejercicios

import kotlin.math.pow

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
            println("\nEl dato no es correcto, intente de nuevo.\n")
        }
    }while (radio == null)
}