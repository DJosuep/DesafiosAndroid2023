package com.example.desafolab2.ejercicios

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